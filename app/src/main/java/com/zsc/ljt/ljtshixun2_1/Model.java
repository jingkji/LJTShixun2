package com.zsc.ljt.ljtshixun2_1;

/**
 * Created by _Li on 2017/5/24.
 */

public class Model {
    public int music_image;
    public String music_name;
    public String singer;
    public String path;

    public Model() {
    }

    public Model(int music_image, String music_name) {
        this.music_image = music_image;
        this.music_name = music_name;
    }

    public Model(int music_image, String music_name, String singer, String path) {
        this.music_image = music_image;
        this.music_name = music_name;
        this.singer = singer;
        this.path = path;
    }

    public int getMusic_image() {
        return music_image;
    }

    public void setMusic_image(int music_image) {
        this.music_image = music_image;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
