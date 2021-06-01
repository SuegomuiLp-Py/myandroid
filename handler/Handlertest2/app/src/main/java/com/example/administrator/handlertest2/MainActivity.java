package com.example.administrator.handlertest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar = null;
    Button startButton = null;
    Button cancleButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar)findViewById(R.id.bar);
        startButton = (Button)findViewById(R.id.bt);
        startButton.setOnClickListener(new startButtonListener());
        cancleButton = (Button)findViewById(R.id.bt2);
        cancleButton.setOnClickListener(new cancleButtonListener());
    }
    class startButtonListener implements OnClickListener {
        public void onClick(View v){
            bar.setVisibility(View.VISIBLE);
            updateBarHandler.post(updateThread);
        }
    }
    class cancleButtonListener implements OnClickListener{
        public void onClick(View v){
            updateBarHandler.removeCallbacks(updateThread);
        }
    }
    Handler updateBarHandler = new Handler(){
        public void handleMessage(Message msg){
            bar.setProgress(msg.arg1);
            updateBarHandler.post(updateThread);
        }
    };
    Runnable updateThread = new Runnable() {
        int i = 0;
        @Override
        public void run() {
            System.out.println("Begin Thread");
            i = i+10;
            Message msg = updateBarHandler.obtainMessage();
            msg.arg1 = i;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            updateBarHandler.sendMessage(msg);
            if(i==100){
                updateBarHandler.removeCallbacks(updateThread);
            }
        }
    };
}
