package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TimerExMain extends AppCompatActivity {

    //private Context mContext;
    //private ArrayList<String> recordList;
    private ListView listView;
    private TimerAdapter adapter;

    TextView hourTv, minuteTv, secondTv, recordTv;
    Button timerStartBT, stopBT, recordBT;
    int hour = 0;
    int minute = 0;
    int second = 0;
    boolean isStop = false;
    String record = "";
    ListView listview ;

    private static Handler mHandler ;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_ex_main);
        adapter = new TimerAdapter();

        listview = (ListView) findViewById(R.id.record);
        listview.setAdapter(adapter);

        //adapter.addItem(hour,":",minute,":",second);
        adapter.addItem("1",":","1",":","1");
        adapter.addItem("2",":","2",":","2");
        adapter.notifyDataSetChanged();

        hourTv = findViewById(R.id.hour) ;
        minuteTv = findViewById(R.id.minute) ;
        secondTv = findViewById(R.id.second) ;
        recordTv = findViewById(R.id.recordText) ;

        timerStartBT = findViewById(R.id.button);
        timerStartBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(" TimeExMain ", "타이머 누름");
                Thread thread = new Thread(new NewRunnable());
                thread.start();
                Log.d(" TimeExMain ", "스레드 시작");
            }
        });

        recordBT = findViewById(R.id.recordButton);
        recordBT.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.d(" TimeExMain ", "기록하기 누름");
                adapter.addItem(""+hour,":",""+minute,":",""+second);
                adapter.notifyDataSetChanged();
            }
        });

        stopBT = findViewById(R.id.stopButton);
        stopBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new NewRunnable());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.interrupt();
                isStop = true;
                Log.d(" TimeExMain ", "스레드 끝");
            }
        });

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //시간이 10 이하이면 앞에 0을 붙히고 뒤에 시간을 붙히고 아니면 시간을 그대로 나타냄
                if(hour<10){
                    hourTv.setText("0"+hour) ;
                }else{
                    hourTv.setText(""+hour) ;
                }

                //분이 10 이하이면 앞에 0을 붙히고 뒤에 분을 붙히고 아니면 분을 그대로 나타냄
                if(minute<10){
                    minuteTv.setText("0"+minute) ;
                }else{
                    minuteTv.setText(""+minute) ;
                }

                //초가 10 이하이면 앞에 0을 붙히고 뒤에 초를 붙히고 아니면 초를 그대로 나타냄
                if(second<10){
                    secondTv.setText("0"+second) ;
                }else{
                    secondTv.setText(""+second) ;
                }
            }
        } ;
    }

    public class NewRunnable implements Runnable {
        @Override
        public void run() {
            while (!isStop) {
                if(second<60){
                    second++;
                }
                if(second == 59){
                    second = 0;
                    if(minute<60){
                        minute++;
                        if(minute == 59){
                            minute = 0;
                            hour++;
                        }
                    }
                }
                try {
                    Thread.sleep(10);
                    Log.d("타이머 누른 후 시간 ", String.valueOf(hour)+"시"+String.valueOf(minute)+"분"+String.valueOf(second));
                } catch (Exception e) {
                    e.printStackTrace() ;
                }
                mHandler.sendEmptyMessage(0) ;
            }
        }
    }
}
