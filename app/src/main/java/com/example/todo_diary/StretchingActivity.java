package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StretchingActivity extends AppCompatActivity {

    int stretchingTimeMax = 6;
    int[] imgs = new int[stretchingTimeMax];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);

        for (int i = 0; i < stretchingTimeMax; i++) {
            imgs[i] = getApplicationContext().getResources().getIdentifier( "minute"+i, "drawable", "com.example.todo_diary");
        }
        ImageView minuteImage = (ImageView) findViewById(R.id.timeImage);
        minuteImage.setImageResource(imgs[stretchingTimeMax-1]);
    }
}
