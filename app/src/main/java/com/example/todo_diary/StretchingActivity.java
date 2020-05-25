package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class StretchingActivity extends AppCompatActivity {

    int stretchingTimeMax = 6;
    int[] stretchingTimeImgs = new int[stretchingTimeMax];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);

        //스트레칭 타임 이미지를 배열에 넣어줌
        for (int i = 0; i < stretchingTimeMax; i++) {
            stretchingTimeImgs[i] = getApplicationContext().getResources().getIdentifier( "minute"+i, "drawable", "com.example.todo_diary");
        }
        ImageView minuteImage = (ImageView) findViewById(R.id.timeImage);
        minuteImage.setImageResource(stretchingTimeImgs[stretchingTimeMax-1]);
    }
}
