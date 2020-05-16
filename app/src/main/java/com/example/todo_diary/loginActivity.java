package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //등록버튼을 누르면 회원가입 액티비티로 이동
        Button goRegisterButton = (Button)findViewById(R.id.goRegisterButton);
        goRegisterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(loginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //로그인을 누르면 앱 메인 액티비티로 이동
        Button loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        //액티비티가 화면에 나타남
        //Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        //액티비티가 화면에 나타나고 상호작용이 가능해짐
        //Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        //액티비티가 다시 시작됨(뒤로가기 버튼으로 돌아왔을 때)
        //Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //다른 액티비티가 시작되려함, 이 액티비티는 중단되려하고 백그라운드로 들어감
        //Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //액티비티가 더 이상 화면에 나타나지 않음,중단된 상태
        //Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //액티비티가 종료.
        //Toast.makeText(this,"onDestroy()", Toast.LENGTH_SHORT).show();
    } */
}
