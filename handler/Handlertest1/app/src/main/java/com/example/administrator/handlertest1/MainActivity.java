package com.example.administrator.handlertest1;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startButton = null;
    private Button endButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.bt1);
        startButton.setOnClickListener(new StartButtonListener());
        endButton = (Button)findViewById(R.id.bt2);
        endButton.setOnClickListener(new EndButtonListener());
    }
    Handler handler = new Handler();
    class  StartButtonListener implements OnClickListener {
        public void onClick(View v){
            handler.post(updateThread);
        }
    }
    class EndButtonListener implements OnClickListener {
        public void onClick(View v){
            handler.removeCallbacks(updateThread);
        }
    }
    Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            System.out.println("UpdateThread");
            Log.v("tag","UpdateThread");
            handler.postDelayed(updateThread,1000);
        }
    };
}
