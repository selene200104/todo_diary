package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StretchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);

        int max = 6;
        int[] imgs = new int[max];

        for (int i = 0; i < max; i++) {
            imgs[i] = getApplicationContext().getResources().getIdentifier( "minute"+i, "drawable", "com.example.todo_diary");
        }

        ImageView minuteImage = (ImageView) findViewById(R.id.timeImage);
        minuteImage.setImageResource(imgs[max-1]);
    }
}
