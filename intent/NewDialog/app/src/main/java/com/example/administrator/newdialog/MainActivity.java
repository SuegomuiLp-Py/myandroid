package com.example.administrator.newdialog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button=(Button)findViewById(R.id.Button01);
        button.setOnClickListener(new Button.OnClickListener(){
                                      public void onClick(View b){
                                          //Intent <Intent_name>=new Intent (<Action>,<Data>);
                                          Intent I=new Intent(Intent.ACTION_DIAL,Uri.parse("tel://114"));
                                          startActivity(I);
                                      }

                                  }
        );
    }
}