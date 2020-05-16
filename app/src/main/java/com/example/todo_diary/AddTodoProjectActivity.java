package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddTodoProjectActivity extends AppCompatActivity {

    private TextView TextSelectedDay;
    int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo_project);

        //취소이미지를 누르면 스케쥴 메인 액티비티로 이동
        ImageButton cancelButton = (ImageButton)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(AddTodoProjectActivity.this, TodoMainActivity.class);
                startActivity(intent);
            }
        });

        //종료일 선택 버튼을 누르면 뜨는 달력 다이어로그를 위한 설정
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        //종료일 선택 버튼
        findViewById(R.id.selectEndDayButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //날짜 선택 다이어로그를 뜨게 함
                new DatePickerDialog(AddTodoProjectActivity.this, dateSetListener, year, month, day).show();
            }
        });

        //체크이미지를 누르면 다이어리 확인 액티비티로 이동
        ImageButton doneButton = (ImageButton)findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(AddTodoProjectActivity.this, TodoMainActivity.class);

                // 다이어리 제목 입력 값을 String 값으로 그대로 전달.
                EditText todoProjectTitle = (EditText) findViewById(R.id.todoProjectName) ;
                intent.putExtra("diaryTitle", todoProjectTitle.getText().toString()) ;
                TodoMainActivity.list.add(0,todoProjectTitle.getText().toString());

                TextView TextSelectedDay = (TextView) findViewById(R.id.TextSelectedDay) ;
                intent.putExtra("selectEndDate", TextSelectedDay.getText().toString()) ;

                startActivity(intent);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
            @SuppressLint("DefaultLocale") String selectedEndDate = String.format("%d 년 %d 월 %d 일" , year,monthOfYear+1, dayOfMonth);
            TextSelectedDay = (TextView) findViewById(R.id.TextSelectedDay);
            TextSelectedDay.setText(selectedEndDate);
            //Toast.makeText(AddTodoProjectActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };

}
