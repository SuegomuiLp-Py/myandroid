package com.example.administrator.ddmstest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button bt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
             Log.v("LogDemo","This is Verbose.");
             Log.d("LogDemo","This is Debug.");
             Log.i("LogDemo","This is Information.");
             Log.w("LogDemo","This is Warnning.");
             Log.e("LogDemo","This is Error.");
            }
        });
    }
}
