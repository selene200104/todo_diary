package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckDiaryActivity extends AppCompatActivity {

    private TextView diaryDate;
    private TextView diaryTitle;
    private TextView textSpot;
    private TextView diaryStory;
    private ImageView diaryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_diary);

        Intent intent = getIntent();

        // 날짜 값을 String 값으로 그대로 표시
        diaryDate = (TextView) findViewById(R.id.today) ;
        String date = intent.getStringExtra("diaryDate") ;
        diaryDate.setText(date) ;

        // 다이어리 제목 입력 값을 String 값으로 그대로 표시
        diaryTitle = (TextView) findViewById(R.id.diaryTitle) ;
        String title = intent.getStringExtra("diaryTitle") ;
        diaryTitle.setText(title) ;

        // 장소 입력 값을 String 값으로 그대로 표시
        textSpot = (TextView) findViewById(R.id.textSpot);;
        String spot = intent.getStringExtra("spot") ;
        textSpot.setText(" @ " + spot) ;

        // 다이어리 내용 값을 String 값으로 그대로 표시
        diaryStory = (TextView) findViewById(R.id.diaryStory);;
        String story = intent.getStringExtra("diaryStory") ;
        diaryStory.setText(story) ;

        // 이미지뷰 값을 bitmap 배열로 받아서 표시
        //  Uri uri = Uri.parse(extras.getString("uri"));

        //메뉴 이미지를 누르면 다이어리 메인 액티비티로 이동
        ImageButton Home = (ImageButton)findViewById(R.id.menuButton);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(CheckDiaryActivity.this, DiaryMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
