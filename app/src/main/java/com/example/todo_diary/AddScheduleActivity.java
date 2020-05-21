package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddScheduleActivity extends AppCompatActivity {

    String scheduleTitle = "";
    String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        //취소이미지를 누르면 스케쥴 메인 액티비티로 이동
        ImageButton cancelButton = (ImageButton)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(AddScheduleActivity.this, ScheduleManagementMainActivity.class);
                startActivity(intent);
            }
        });

        //체크이미지를 누르면 스케쥴 메인 액티비티로 이동
        ImageButton doneButton = (ImageButton)findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(AddScheduleActivity.this, ScheduleManagementMainActivity.class);

                // 다이어리 제목 입력 값을 String 값으로 그대로 전달.
                EditText scheduleName = (EditText) findViewById(R.id.scheduleName) ;
                intent.putExtra("diaryTitle", scheduleName.getText().toString()) ;
                //ScheduleManagementMainActivity.scheduleItemList.add(scheduleName.getText().toString());
                startActivity(intent);

                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();

                try {
                    jsonObject.put("scheduleTitle", scheduleName.getText().toString());
                    jsonArray.put(jsonObject);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                jsonData = jsonArray.toString();

                SharedPreferences diaryList = getSharedPreferences("schedule", MODE_PRIVATE);
                SharedPreferences.Editor editor = diaryList.edit();
                editor.putString("scheduleTitle", jsonData);
                editor.apply();
                /*
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();

                try{
                    jsonObject.put("diaryTitle", scheduleName.getText().toString());
                    jsonArray.put(jsonObject);
                } catch (JSONException e){
                    e.printStackTrace();
                }

                String jsondata = jsonArray.toString();

                SharedPreferences scheduleText = getSharedPreferences("scheduleText", AppCompatActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = scheduleText.edit();

                editor.putString("scheduleText", jsondata);
                editor.apply();

                loadArrayList(ScheduleManagementMainActivity.class);*/
            }
        });
    }

    //EditText에서 입력한 값을 SharedPreferences에 저장
    /*private void saveArrayList(String jsondata){
        SharedPreferences scheduleText = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = scheduleText.edit();

        editor.putString("jsonData", jsondata);
        editor.apply();
    } */

    //SharedPreferences에 저장한 것을 listView에 입력
    /*
    private void loadArrayList(Class<ScheduleManagementMainActivity> context) {
        SharedPreferences saveSchedule = PreferenceManager.getDefaultSharedPreferences(this);
        //int size = sharedPrefs2.getInt("appreciation_size",0);
        String strJson = saveSchedule.getString("scheduleText", "fail");
        if (strJson != "fail") {
            try {
                JSONArray response = new JSONArray(strJson);
                for (int i = 0; i < response.length(); i++) {
                    JSONObject jsonobject = response.getJSONObject(i);
                    diaryTitle = jsonobject.getString("title");
                    ScheduleManagementMainActivity.scheduleItemList.add(diaryTitle);
                }
                ScheduleManagementMainActivity.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , ScheduleManagementMainActivity.scheduleItemList);
                ScheduleManagementMainActivity.listview.setAdapter(ScheduleManagementMainActivity.adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ScheduleManagementMainActivity.adapter.notifyDataSetChanged();
        }
    }*/
}
