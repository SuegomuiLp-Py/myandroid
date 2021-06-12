package com.example.administrator.musicplayer;

import java.util.ArrayList;


public class MusicList {

    private static ArrayList<Music> musicarray = new ArrayList<Music>();
    private MusicList(){}

    public static ArrayList<Music> getMusicList()
    {
        return musicarray;
    }
}
