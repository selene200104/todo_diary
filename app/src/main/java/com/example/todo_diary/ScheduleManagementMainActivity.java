package com.example.todo_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        Log.d(TAG, "today: date : " + today);
        thisDay = (TextView) findViewById(R.id.thisDay);
        thisDay.setText(today);

        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listview = (ListView) findViewById(R.id.scheduleListView);
        listview.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listview.setAdapter(adapter);

        //길게 클릭하면 해당 값이 삭제할지 말지 물어보는 다이얼로그가 뜬다
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           final int position, long id) {

                //다이얼로그 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("삭제하시겠어요?").setMessage("삭제하시려면 '네'를 선택해주세요.");

                //아니요를 누르면 다이얼로그가 닫히고
                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Toast.makeText(getApplicationContext(), "Cancel Click", Toast.LENGTH_SHORT).show();
                    }
                });

                //네를 누르면 리스트뷰의 해당 데이터가 삭제된다
                builder.setPositiveButton("네", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
                    }
                });

                //다이얼로그 생성과 보여주기(없으면 다이얼로그가 뜨지 않음)
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return true;
            }
        });

        //메뉴 이미지를 누르면 메인 액티비티로 이동
        ImageButton Home = (ImageButton) findViewById(R.id.menuButton);
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
                String date = year + "." + (month + 1) + "." + dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: date : " + date);
                thisDay = (TextView) findViewById(R.id.thisDay);
                thisDay.setText(date);

            }
        });
        //플러스이미지를 누르면 스케쥴추가 액티비티로 이동
        ImageButton addScheduleButton = (ImageButton) findViewById(R.id.addScheduleButton);
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