package com.example.todo_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;

public class ScheduleManagementMainActivity extends AppCompatActivity {

    private static final String TAG = "ScheduleMainActivity";
    private TextView thisDay;
    ListView listview;
    static ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @SuppressLint("SimpleDateFormat")
    // 날짜를 나타냇 포맷을 정함 ( 원하는대로 형태 변경 가능 )
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.M.d");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_management_main);

        // 오늘 날짜를 스케쥴관리메인 액티비티가 만들어질때 출력함
        Date date = new Date();
        // today 변수에 포맷에 맞게 값을 저장한다.
        String today = dateFormat.format(date);
        Log.d(TAG,"today: date : " + today);
        thisDay = (TextView) findViewById(R.id.thisDay);
        thisDay.setText(today);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list) ;

        listview = (ListView) findViewById(R.id.scheduleListView) ;
        listview.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listview.setAdapter(adapter);

        //메뉴 이미지를 누르면 메인 액티비티로 이동
        ImageButton Home = (ImageButton)findViewById(R.id.menuButton);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(ScheduleManagementMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "." + (month+1) + "." + dayOfMonth ;
                Log.d(TAG,"onSelectedDayChange: date : " + date);
                thisDay = (TextView) findViewById(R.id.thisDay);
                thisDay.setText(date);

            }
        });
        //플러스이미지를 누르면 스케쥴추가 액티비티로 이동
        ImageButton addScheduleButton = (ImageButton)findViewById(R.id.addScheduleButton);
        addScheduleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(ScheduleManagementMainActivity.this, AddScheduleActivity.class);
                startActivity(intent);
            }
        });
    }

}
