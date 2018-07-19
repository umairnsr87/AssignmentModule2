package com.example.umairansari.assignmentmodule2;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.provider.Telephony;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button green,red,blue,yahoo,google;
    WebView web;
    LinearLayout lll;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lll=findViewById(R.id.ll);
        green=findViewById(R.id.BtnGreen);
        red=findViewById(R.id.BtnRed);
        blue=findViewById(R.id.BtnBlue);
        yahoo=findViewById(R.id.BtnYahoo);
        google=findViewById(R.id.BtnGoogle);
        web=findViewById(R.id.Webview);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lll.setBackgroundColor(android.R.color.holo_green_dark);
                Log.i("Tag","greenColorCHANged");
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lll.setBackgroundColor(android.R.color.holo_red_dark);
                Log.i("Tag","redColorCHANged");
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Tag","in on click");
                lll.setBackgroundColor(android.R.color.black);
                Log.i("Tag","redColorCHANged");

            }
        });
        yahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.setWebViewClient(new WebViewClient());
                web.getSettings().setJavaScriptEnabled(true);
                web.loadUrl("https://in.yahoo.com/");
            }
        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.setWebViewClient(new WebViewClient());
                web.getSettings().setJavaScriptEnabled(true);
                web.loadUrl("https://www.google.co.in");
            }
        });
    }
    void Broadcast()
    {
        IntentFilter intentFilter=new IntentFilter();
        
    }
    class SMSBroadcast extends BroadcastReceiver{

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onReceive(Context context, Intent intent) {

            if(Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction()))
            {
                for(SmsMessage sms:Telephony.Sms.Intents.getMessagesFromIntent(intent))
                {
                    String message=sms.getMessageBody();
                    Toast.makeText(MainActivity.this,"message broadcasted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
