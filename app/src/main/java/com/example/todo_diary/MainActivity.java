package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //달력이미지를 누르면 스케쥴관리 액티비티로 이동
        ImageButton goScheduleButton = (ImageButton)findViewById(R.id.goScheduleButton);
        goScheduleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(MainActivity.this, ScheduleManagementMainActivity.class);
                startActivity(intent);
            }
        });

        //TO_DO 이미지를 누르면 TodoMain 액티비티로 이동
        ImageButton goToDoListButton = (ImageButton)findViewById(R.id.goToDoListButton);
        goToDoListButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(MainActivity.this, TodoMainActivity.class);
                startActivity(intent);
            }
        });

        //다이어리 이미지를 누르면 다이어리 액티비티로 이동
        ImageButton goDiaryButton = (ImageButton)findViewById(R.id.goDiaryButton);
        goDiaryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(MainActivity.this, DiaryMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
