package com.example.todo_diary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DiaryMainActivity extends AppCompatActivity {

    static ArrayList<DiaryItem> arrayList = new ArrayList<>();
    static DiaryAdapter diaryAdapter;
    static RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

        recyclerView = (RecyclerView)findViewById(R.id.diaryListView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        diaryAdapter = new DiaryAdapter(arrayList);
        recyclerView.setAdapter(diaryAdapter);
        diaryAdapter.notifyDataSetChanged();

        //메뉴 이미지를 누르면 메인 액티비티로 이동
        ImageButton Home = (ImageButton)findViewById(R.id.menuButton);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(DiaryMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton addDiaryButton = findViewById(R.id.addDiaryButton);
        addDiaryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(DiaryMainActivity.this, WriteDiaryActivity.class);
                startActivity(intent);
            }

        });



    }
}
