package com.example.administrator.musicplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class MainActivity extends Activity {

    private ImageButton imgBtn_Previous;
    private ImageButton imgBtn_PlayOrPause;
    private ImageButton imgBtn_Stop;
    private ImageButton imgBtn_Next;
    private ListView list;

    private ArrayList<Music> musicArrayList;

    private int number = 0;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        registerListeners();
        initMusicList();
        initListView();
        checkMusicfile();
    }

    private void findViews() {
        imgBtn_Previous = (ImageButton) findViewById(R.id.imageButton1);
        imgBtn_PlayOrPause = (ImageButton) findViewById(R.id.imageButton2);
        imgBtn_Stop = (ImageButton) findViewById(R.id.imageButton3);
        imgBtn_Next = (ImageButton) findViewById(R.id.imageButton4);
        list = (ListView) findViewById(R.id.listView1);
    }


    private void registerListeners() {
        imgBtn_Previous.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                moveNumberToPrevious();
                play(number);
                imgBtn_PlayOrPause.setBackgroundResource(R.drawable.button_pause);
            }
        });
        imgBtn_PlayOrPause.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (player != null && player.isPlaying()) {
                    pause();
                    imgBtn_PlayOrPause.setBackgroundResource(R.drawable.button_play);
                } else {
                    play(number);
                    imgBtn_PlayOrPause.setBackgroundResource(R.drawable.button_pause);
                }
            }
        });
        imgBtn_Stop.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                stop();
                imgBtn_PlayOrPause.setBackgroundResource(R.drawable.button_play);
            }
        });
        imgBtn_Next.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                moveNumberToNext();
                play(number);
                imgBtn_PlayOrPause.setBackgroundResource(R.drawable.button_pause);
            }
        });
        list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                number = position ;
                play(number);
                imgBtn_PlayOrPause.setBackgroundResource(R.drawable.button_pause);
            }
        });
    }

    private void initMusicList() {
        musicArrayList = MusicList.getMusicList();

        if(musicArrayList.isEmpty())
        {
            Cursor mMusicCursor = this.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                    MediaStore.Audio.AudioColumns.TITLE);

            int indexTitle = mMusicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
            int indexArtist = mMusicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
            int indexTotalTime = mMusicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
            int indexPath = mMusicCursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
            for (mMusicCursor.moveToFirst(); !mMusicCursor.isAfterLast(); mMusicCursor
                    .moveToNext()) {
                String strTitle = mMusicCursor.getString(indexTitle);
                String strArtist = mMusicCursor.getString(indexArtist);
                String strTotoalTime = mMusicCursor.getString(indexTotalTime);
                String strPath = mMusicCursor.getString(indexPath);

                if (strArtist.equals("<unknown>"))
                    strArtist = "无艺术家";
                Music music = new Music(strTitle, strArtist, strPath, strTotoalTime);
                musicArrayList.add(music);
            }
        }
    }

    private void initListView() {
        List<Map<String, String>> list_map = new ArrayList<Map<String, String>>();
        HashMap<String, String> map;
        SimpleAdapter simpleAdapter;
        for (Music music : musicArrayList) {
            map = new HashMap<String, String>();
            map.put("musicName", music.getmusicName());
            map.put("musicArtist", music.getmusicArtist());
            list_map.add(map);
        }

        String[] from = new String[] { "musicName", "musicArtist" };
        int[] to = { R.id.listview_tv_title_item, R.id.listview_tv_artist_item };

        simpleAdapter = new SimpleAdapter(this, list_map, R.layout.listview,from, to);
        list.setAdapter(simpleAdapter);
    }

    private void checkMusicfile()
    {
        if (musicArrayList.isEmpty()) {
            imgBtn_Next.setEnabled(false);
            imgBtn_PlayOrPause.setEnabled(false);
            imgBtn_Previous.setEnabled(false);
            imgBtn_Stop.setEnabled(false);
            Toast.makeText(getApplicationContext(), "当前没有歌曲文件",Toast.LENGTH_SHORT).show();
        } else {
            imgBtn_Next.setEnabled(true);
            imgBtn_PlayOrPause.setEnabled(true);
            imgBtn_Previous.setEnabled(true);
            imgBtn_Stop.setEnabled(true);
        }
    }

    private MediaPlayer player = new MediaPlayer();

    private void load(int number) {
        try {
            player.reset();
            player.setDataSource(MusicList.getMusicList().get(number).getmusicPath());
            player.prepare();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void play(int number) {
        if (player != null && player.isPlaying()) {
            player.stop();
        }
        load(number);
        player.start();
    }

    private void pause() {
        if (player.isPlaying()) {
            player.pause();
        }
    }

    private void stop() {
        player.stop();
    }

    private void resume() {
        player.start();
    }

    private void replay() {
        player.start();
    }

    private void moveNumberToNext() {
        if ((number ) == MusicList.getMusicList().size()-1) {
            Toast.makeText(MainActivity.this,MainActivity.this.getString(R.string.tip_reach_bottom),Toast.LENGTH_SHORT).show();
        } else {
            ++number;
            play(number);
        }
    }

    private void moveNumberToPrevious() {
        if (number == 0) {
            Toast.makeText(MainActivity.this,MainActivity.this.getString(R.string.tip_reach_top),Toast.LENGTH_SHORT).show();
        } else {
            --number;
            play(number);
        }
    }
}