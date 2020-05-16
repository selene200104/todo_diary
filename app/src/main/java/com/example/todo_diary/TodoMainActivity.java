package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class TodoMainActivity extends AppCompatActivity {
    TextView addTodoProject;

    ListView listview;
    static ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_main);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list) ;
        listview = (ListView) findViewById(R.id.todoProjectList) ;
        listview.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listview.setAdapter(adapter);

        //메뉴 이미지를 누르면 메인 액티비티로 이동
        ImageButton Home = (ImageButton)findViewById(R.id.menuButton);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(TodoMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addTodoProject = (TextView) findViewById(R.id.addTodoProject);
        addTodoProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TodoMainActivity.this, AddTodoProjectActivity.class);
                startActivity(intent);
            }
        });
    }
}
