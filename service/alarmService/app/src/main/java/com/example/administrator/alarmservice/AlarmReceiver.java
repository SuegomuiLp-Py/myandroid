package com.example.administrator.alarmservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver{
    public void onReceive(Context context, Intent arg1){
        context.startService(new Intent(context,NotifyService.class));
    }
}
