package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class TodoCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_check);

        Intent intent = getIntent();

        // 프로젝트 이름 값을 String 값으로 그대로 표시
        TextView todoProjectTitle = (TextView) findViewById(R.id.TextTodoProjectName) ;
        String projectTitle = intent.getStringExtra("diaryTitle") ;
        todoProjectTitle.setText(projectTitle) ;

        // 프로젝트 종료 값을 String 값으로 그대로 표시
        TextView TextEndDate = (TextView) findViewById(R.id.TextEndDate) ;
        String projectEndDate = intent.getStringExtra("selectEndDate") ;
        TextEndDate.setText(projectEndDate) ;

        //화살표 이미지를 누르면 투두 메인 액티비티로 이동
        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(TodoCheckActivity.this, TodoMainActivity.class);
                startActivity(intent);
            }
        });

    }
}
