package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView profileNickname;
    String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileNickname = (TextView)findViewById(R.id.profileNickname);

        SharedPreferences login = getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE);
        nickName = login.getString("registerNickName",nickName);
        profileNickname.setText(nickName);

        ImageButton logoutButton = (ImageButton)findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences에 저장된 값들을 로그아웃 버튼을 누르면 삭제하기 위해
                //로그인 액티비티에서 만든 이름으로 SharedPreferences를 불러옴
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
                SharedPreferences login = getSharedPreferences("auto", AppCompatActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = login.edit();
                //editor.clear()는 auto에 들어있는 모든 정보를 기기에서 지움
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this, "로그아웃하였습니다", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

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

        //메뉴 이미지를 누르면 메인 액티비티로 이동
        ImageButton Home = (ImageButton)findViewById(R.id.menuButton);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
