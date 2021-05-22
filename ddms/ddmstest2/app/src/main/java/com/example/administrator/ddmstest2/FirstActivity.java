package com.example.administrator.ddmstest2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends Activity {
private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.v("LogActivity", "FirstAcvity onCreate");
        bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new ButtonOnClickListener());
    }
    class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(FirstActivity.this, SecondActivity.class);
            FirstActivity.this.startActivity(intent);
        }
    }
        @Override
        protected void onDestroy() {
            // TODO Auto-generated method stub
            Log.v("LogActivity","FirstAcvity onDestory");
            super.onDestroy();
        }

        @Override
        protected void onPause() {
            // TODO Auto-generated method stub
            Log.v("LogActivity", "FirstAcvity onPause");
            super.onPause();
        }

        @Override
        protected void onRestart() {
            // TODO Auto-generated method stub
            Log.v("LogActivity", "FirstAcvity onRestart");
            super.onRestart();
        }

        @Override
        protected void onResume() {
            // TODO Auto-generated method stub
            Log.v("LogActivity", "FirstAcvity onResume");
            super.onResume();
        }

        @Override
        protected void onStart() {
            // TODO Auto-generated method stub
            Log.v("LogActivity", "FirstAcvity onStart");
            super.onStart();
        }

        @Override
        protected void onStop() {
            // TODO Auto-generated method stub
            Log.v("LogActivity", "FirstAcvity onStop");
            super.onStop();
        }
    }
