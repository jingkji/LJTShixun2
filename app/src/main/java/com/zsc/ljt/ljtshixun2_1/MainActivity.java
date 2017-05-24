package com.zsc.ljt.ljtshixun2_1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //抽屉式布局
    private DrawerLayout mDrawerLayout;
    //歌曲列表布局
    RecyclerView mRecyclerView;
    //存储歌曲信息的List列表
    private List<Model> mModelList = new ArrayList<>();
    //给RecyclerView放数据的适配器
    MyAdapter mAdapter;
    //扫描歌曲
    Saomiao saomiao;

    //关于按钮
    TextView about;

    //切换背景图片的按钮
    //LinearLayout mLinearLayout;
    CoordinatorLayout mCoordinatorLayout;
    static int[] bg_img = { R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4 };
    static int bgflag = 1;


    /**
     * 测试RecyclerView数据 Model
     */
    public  Model[] models = { new Model(R.drawable.music_img, "Apple", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Banana", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Orange", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Watermelon", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Pear", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Grape", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Pineapple", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Strawberry", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Cherry", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Strawberry", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Dgwgfs", "手嶌葵", "abc"),
            new Model(R.drawable.music_img, "Pwegwe", "手嶌葵", "abc") };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mLinearLayout = (LinearLayout) findViewById(R.id.ll);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coorlayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setCheckedItem(R.id.nav_checkedIn);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_checkedIn:
                        break;
                    case R.id.nav_VIP:
                        break;
                    case R.id.nav_durClose:
                        break;
                    case R.id.nav_clock:
                        break;
                    case R.id.nav_help:
                        break;
                    case R.id.nav_exit:
                        Intent intent = new Intent();
                        intent.setAction("ACTION_ISPLAY");
                        intent.putExtra("isplay", false);
                        sendBroadcast(intent);
                        MainActivity.this.finish();
                        break;
                    default:
                        break;

                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        /**
         * 扫描手机内歌曲到List<>里
         */
        //saomiao = new Saomiao();
        //mModelList = saomiao.query(this);

        /**
         * 测试RecyclerView
         */
        initMusic();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(mModelList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnRecyclerViewItemClickListener(new MyOnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //isplay = true;

                //playm.setImageResource(R.drawable.dainji_20);

                Intent intent = new Intent();
                intent.setAction("ACTION_INDEX");
                intent.putExtra("index", position);
                sendBroadcast(intent);
                Toast.makeText(MainActivity.this, "你点击的是" + position, Toast.LENGTH_SHORT).show();
            }
        });
/*
        about = (TextView) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
        */
    }

    private void initMusic() {
        mModelList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(models.length);
            mModelList.add(models[index]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.img_2:
                mCoordinatorLayout.setBackgroundResource(bg_img[bgflag]);
                bgflag = (bgflag + 1) % bg_img.length;
                break;
            default:
                break;
        }
        return true;
    }
}
