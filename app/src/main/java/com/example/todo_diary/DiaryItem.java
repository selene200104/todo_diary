package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DiaryItem {
    private int picture;
    private String title;
    private String date;
    private String spot;
    private String diaryStory;


    public DiaryItem(int picture,String title,String date,String spot, String diaryStory) {
        this.picture = picture;
        this.title = title;
        this.date = date;
        this.spot = spot;
        this.diaryStory = diaryStory;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getDiaryStory() {
        return diaryStory;
    }

    public void setDiaryStory(String diaryStory) {
        this.diaryStory = diaryStory;
    }
}
