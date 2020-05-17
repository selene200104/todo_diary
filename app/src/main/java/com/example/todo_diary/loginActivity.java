package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText id, password;
    Button loginButton;
    String loginId, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = (EditText)findViewById(R.id.emailAddress);
        password = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.loginButton);

        SharedPreferences login = getSharedPreferences("auto", AppCompatActivity.MODE_PRIVATE);

        loginId = login.getString("inputId",null);
        loginPassword = login.getString("inputPassword",null);

        if(loginId == null && loginPassword == null) {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //아이디와 비밀번호에 입력된 값이 미리 지정되어있는 값과 같으면 로그인이 됌.
                    if (id.getText().toString().equals("juhee@naver.com") && password.getText().toString().equals("951215")) {
                        SharedPreferences login = getSharedPreferences("auto", AppCompatActivity.MODE_PRIVATE);
                        //아이디가 'juhee'이고 비밀번호가 '951215'일 경우 SharedPreferences.Editor를 통해
                        //login(SharedPreferences)의 loginId와 loginPwd에 값을 저장해 줌
                        SharedPreferences.Editor autoLogin = login.edit();
                        autoLogin.putString("inputId", id.getText().toString());
                        autoLogin.putString("inputPwd", password.getText().toString());
                        //commit()을 통해 값 저장(하지 않으면 저장이 되지 않음)
                        autoLogin.commit();
                        //Toast를 통해 환영메세지를 띄움
                        Toast.makeText(loginActivity.this, id.getText().toString() + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                        //로그인 액티비티에서 메인 액티비티로 넘어감
                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }

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
