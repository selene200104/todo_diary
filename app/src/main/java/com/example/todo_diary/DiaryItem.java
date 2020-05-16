package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DiaryItem {
    private int picture;
    private String title;
    private String date;


    public DiaryItem(int picture,String title,String date) {
        this.picture = picture;
        this.title = title;
        this.date = date;
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
}
