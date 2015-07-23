package com.zwb.photodemo.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2015/7/22 0022.
 */

@Table(name = "Songs")
public class Songs {
    @Id(column = "id")
    @NoAutoIncrement
    private long song_id;
    @Column(column = "song_title")
    private String song_title;
    @Column(column = "album_title")
    private String album_title;
    @Column(column = "artist_name")
    private String artist_name;
    @Column(column = "picture_300_300")
    private String picture_300_300;
    @Column(column = "play_num")
    private int play_num;


    public long getSong_id() {
        return song_id;
    }

    public void setSong_id(long song_id) {
        this.song_id = song_id;
    }

    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getPicture_300_300() {
        return picture_300_300;
    }

    public void setPicture_300_300(String picture_300_300) {
        this.picture_300_300 = picture_300_300;
    }

    public int getPlay_num() {
        return play_num;
    }

    public void setPlay_num(int play_num) {
        this.play_num = play_num;
    }
}
