package com.example.administrator.alarmservice;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class NotifyService extends Service {
    public IBinder onBind(Intent arg0){
        return null;
    }
    public void onCreate(){
        MainActivity app = MainActivity.getApp();
        app.btEvent("from NotifyService");
        Toast.makeText(this,"这是系统自带的service",Toast.LENGTH_LONG).show();
    }
}
