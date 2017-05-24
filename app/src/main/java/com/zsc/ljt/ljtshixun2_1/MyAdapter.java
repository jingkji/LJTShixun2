package com.zsc.ljt.ljtshixun2_1;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by _Li on 2017/5/24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context mContext;
    private List<Model> mModelList;

    /**
     * 自定义的ViewHolder，持有每个Item的的所有界面元素
     */
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView musicView;
        ImageView musicImage;
        TextView musicName;
        TextView singerName;
        TextView path;

        public ViewHolder(View view) {
            super(view);
            musicView =  (CardView)view;
            musicImage = (ImageView) view.findViewById(R.id.music_image);
            musicName = (TextView) view.findViewById(R.id.music_name);
            singerName = (TextView) view.findViewById(R.id.singer_name);
            path = (TextView) view.findViewById(R.id.path_name);
        }
    }

    public  MyAdapter(List<Model> modelList) {
        mModelList = modelList;
    }

    /**
     *  创建新View，被LayoutManager所调用
     * @param parent 父容器，外面嵌套的一般是LinearLayout
     * @param viewType  并不知道是什么- -
     * @return  一个ViewHolder用来操作数据
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.music_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.musicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if(mOnRecyclerViewItemClickListener != null)
                {
                    mOnRecyclerViewItemClickListener.onItemClick(v, position);
                }
            }
        });

        return holder;
    }

    /**
     * 将数据与界面进行绑定的操作
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = mModelList.get(position);
        holder.musicName.setText(model.getMusic_name());
        holder.singerName.setText(model.getSinger());
        holder.path.setText(model.getPath());
        Glide.with(mContext).load(model.getMusic_image()).into(holder.musicImage);
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }


    // 添加接口以及设置Adapter接口的方法
    private MyOnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener = null;
    public void setOnRecyclerViewItemClickListener(MyOnRecyclerViewItemClickListener listener) {
        this.mOnRecyclerViewItemClickListener = listener;
    }
}
