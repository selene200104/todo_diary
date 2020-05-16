package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        //취소이미지를 누르면 스케쥴 메인 액티비티로 이동
        ImageButton cancelButton = (ImageButton)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(AddScheduleActivity.this, ScheduleManagementMainActivity.class);
                startActivity(intent);
            }
        });

        //체크이미지를 누르면 스케쥴 메인 액티비티로 이동
        ImageButton doneButton = (ImageButton)findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(AddScheduleActivity.this, ScheduleManagementMainActivity.class);

                // 다이어리 제목 입력 값을 String 값으로 그대로 전달.
                EditText scheduleName = (EditText) findViewById(R.id.scheduleName) ;
                intent.putExtra("diaryTitle", scheduleName.getText().toString()) ;
                ScheduleManagementMainActivity.list.add(scheduleName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
