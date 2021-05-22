package com.example.administrator.ddmstest2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("LogActivity", "SecondActivity onCreate");
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        Log.v("LogActivity","SecondActivity onDestory");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Log.v("LogActivity", "SecondActivity onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        Log.v("LogActivity", "SecondActivity onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Log.v("LogActivity", "SecondActivity onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        Log.v("LogActivity", "SecondActivity onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        Log.v("LogActivity", "SecondActivity onStop");
        super.onStop();
    }
}
