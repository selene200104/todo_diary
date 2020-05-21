package com.example.todo_diary;

public class scheduleItem {
    private String scheduleText;

    public scheduleItem(String scheduleText){
        this.scheduleText = scheduleText;
    }

    public String getScheduleText() {
        return this.scheduleText;
    }

    public void setScheduleText(String scheduleText) {
        this.scheduleText = scheduleText;
    }
}
