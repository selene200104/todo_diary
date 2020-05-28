package com.example.todo_diary;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Collections;
import java.util.Set;

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

                //Toast toast = Toast.makeText(ContentView.this, R.string.messageWordAddedToFarvourite, Toast.LENGTH_SHORT);
                //toast.show();

                //SharedPreferences login = getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE);
                //SharedPreferences.Editor editor = login.edit();


                // 회원가입에서 등록된 아이디를 login SharedPreferences에 저장
                //EditText emailRegister = (EditText) findViewById(R.id.emailRegister);

                // 회원가입에서 등록된 비밀번호를 login SharedPreferences에 저장
                //EditText passwordRegister = (EditText) findViewById(R.id.passwordRegister);

                // 회원가입에서 등록된 닉네임을 login SharedPreferences에 저장
                //EditText nickName = (EditText) findViewById(R.id.textSetNickName);

                /*SharedPreferences loginArray = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                {
                    Set<String> faveSet = loginArray.getStringSet("account", Collections.singleton(""));
                    faveSet.add(emailRegister.getText().toString() + "," + passwordRegister.getText().toString() + "," + nickName.getText().toString() + ";");
                    SharedPreferences.Editor editor = loginArray.edit();
                    editor.putStringSet("account", faveSet);
                    editor.apply();
                }
                Log.i("로그인에 저장되었습니다", "Favourite saved!");*/

                //Toast toast = Toast.makeText(ContentView.this, R.string.messageWordAddedToFarvourite, Toast.LENGTH_SHORT);
                //toast.show();

                SharedPreferences login = getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = login.edit();

                // 회원가입에서 등록된 아이디를 login SharedPreferences에 저장
                EditText emailRegister = (EditText) findViewById(R.id.emailRegister) ;
                Toast.makeText(RegisterActivity.this, "이메일 주소 : "+emailRegister.getText().toString(), Toast.LENGTH_SHORT).show();

                // 회원가입에서 등록된 비밀번호를 login SharedPreferences에 저장
                EditText passwordRegister = (EditText) findViewById(R.id.passwordRegister) ;
                Toast.makeText(RegisterActivity.this, "비밀번호 : "+passwordRegister.getText().toString(), Toast.LENGTH_SHORT).show();

                // 회원가입에서 등록된 닉네임을 login SharedPreferences에 저장
                EditText nickName = (EditText) findViewById(R.id.textSetNickName) ;
                Toast.makeText(RegisterActivity.this, "비밀번호 : "+passwordRegister.getText().toString(), Toast.LENGTH_SHORT).show();

                editor.putString("register", emailRegister.getText().toString()+","+passwordRegister.getText().toString()+","+nickName.getText().toString());
                editor.apply();
            }
        });

    }
}
