package com.zsc.ljt.ljtshixun2_1;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by _Li on 2017/5/24.
 */

public class Saomiao {
    public ArrayList<Model> query(Context mcontext){
        ArrayList<Model> arraylist=null;
        //扫描->游标
        Cursor cursor = mcontext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

        if(cursor != null){
            arraylist = new ArrayList<Model>();


            while(cursor.moveToNext() ){

                Model model;
                model = new Model();

                String music_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));

                String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));

                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));


                model.setMusic_image(R.drawable.music_img);
                model.setMusic_name(music_name);
                model.setSinger(singer);
                model.setPath(path);

                arraylist.add(model);
            }
        }
        return arraylist;
    }
}
