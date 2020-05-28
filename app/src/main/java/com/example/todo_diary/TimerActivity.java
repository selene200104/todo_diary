package com.example.todo_diary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimerActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_timer);
        adapter = new TimerAdapter();

        listview = (ListView) findViewById(R.id.record);
        listview.setAdapter(adapter);

        //adapter.addItem(hour,":",minute,":",second);
        //adapter.addItem("1", ":", "1", ":", "1");
        //adapter.addItem("2", ":", "2", ":", "2");
        adapter.notifyDataSetChanged();

        hourTv = findViewById(R.id.hour);
        minuteTv = findViewById(R.id.minute);
        secondTv = findViewById(R.id.second);
        recordTv = findViewById(R.id.recordText);

        //메뉴 이미지를 누르면 메인 액티비티로 이동
        ImageButton Home = (ImageButton)findViewById(R.id.menuButton);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(TimerActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        //타이머 시작 버튼을 누르면 시작됌
        timerStartBT = findViewById(R.id.button);
        timerStartBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountTask count = new CountTask();
                count.execute();
            }
        });

        //기록하기 버튼을 누르면 기록됌
        recordBT = findViewById(R.id.recordButton);
        recordBT.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.d(" TimeExMain ", "기록하기 누름");
                adapter.addItem("" + hour, ":", "" + minute, ":", "" + second);
                adapter.notifyDataSetChanged();
            }
        });

        //멈추기 버튼을 누르면 멈춤
        stopBT = findViewById(R.id.stopButton);
        stopBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStop = true;
            }
        });
    }

    class CountTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected Void doInBackground(Integer... params) {
            while (!isStop) {
                try {
                    Thread.sleep(1000);
                    if(second<60){
                        second++;
                    }if(second == 59){
                        second = 0;
                        if(minute<60){
                            minute++;
                            if(minute == 59){
                                minute = 0;
                                hour++;
                            }
                        }
                    }
                    Log.d("타이머 누른 후 시간 ", String.valueOf(hour)+"시"+String.valueOf(minute)+"분"+String.valueOf(second));
                } catch (Exception e) {
                    e.printStackTrace() ;
                }
                { publishProgress(second,minute,hour); }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
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

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
