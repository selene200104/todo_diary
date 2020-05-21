package com.example.todo_diary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DiaryMainActivity extends AppCompatActivity {

    public static DiaryItem diaryItem;
    static ArrayList<DiaryItem> arrayList = new ArrayList<>();
    static DiaryAdapter diaryAdapter;
    static RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    int picture;
    String diaryDate, diaryTitle, spot, diaryText, diaryStory, jsonData;;
    private Object Context;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

        recyclerView = (RecyclerView)findViewById(R.id.diaryListView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //diaryAdapter = new DiaryAdapter(arrayList);
        //recyclerView.setAdapter(diaryAdapter);
        //diaryAdapter.notifyDataSetChanged();

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

        //SharedPreferences diaryList = getSharedPreferences("Diary", MODE_PRIVATE);
        //diaryTitle = diaryList.getString("Diary", jsonData);

        //다이어리에 저장된 값을 불러온다
        SharedPreferences diaryList = getSharedPreferences("jsonData", MODE_PRIVATE);
        String diaryTitleStr = diaryList.getString("jsonData", "fail");
        if (!diaryTitleStr.equals("fail")) {
            try {
                //다시 jsonArray에 값을 넣음
                JSONArray response = new JSONArray(diaryTitleStr);
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonobject = response.getJSONObject(i);
                    diaryDate = jsonobject.getString("diaryDate");
                    diaryTitle = jsonobject.getString("diaryTitle");
                    spot = jsonobject.getString("spot");
                    diaryText = jsonobject.getString("diaryStory");
                    arrayList.add(new DiaryItem(picture, diaryDate, diaryTitle, spot, diaryText));
                }
                diaryAdapter = new DiaryAdapter(arrayList);
                recyclerView.setAdapter(diaryAdapter);
                diaryAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        diaryAdapter.notifyDataSetChanged();
    }
}
