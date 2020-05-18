package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    String registerEmailID, registerPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //뒤로가기버튼 이미지를 누르면 로그인 액티비티로 이동
        ImageButton backArrowButton = (ImageButton)findViewById(R.id.backArrowButton);
        backArrowButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        //등록버튼을 누르면 회원가입 액티비티로 이동
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                startActivity(intent);

                SharedPreferences login = getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = login.edit();

                // 회원가입에서 등록된 아이디를 login SharedPreferences에 저장
                EditText emailRegister = (EditText) findViewById(R.id.emailRegister) ;
                editor.putString("registerEmailID", emailRegister.getText().toString());
                editor.commit();
                Toast.makeText(RegisterActivity.this, "이메일 주소 : "+emailRegister.getText().toString(), Toast.LENGTH_SHORT).show();

                // 회원가입에서 등록된 비밀번호를 login SharedPreferences에 저장
                EditText passwordRegister = (EditText) findViewById(R.id.passwordRegister) ;
                editor.putString("registerPassword", passwordRegister.getText().toString());
                editor.commit();
                Toast.makeText(RegisterActivity.this, "비밀번호 : "+passwordRegister.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
