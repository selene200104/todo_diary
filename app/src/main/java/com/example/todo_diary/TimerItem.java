package com.example.todo_diary;

public class TimerItem {
    private String hour ;
    private String firstConnect ;
    private String minute ;
    private String secondConnect ;
    private String second ;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getFirstConnect() {
        return firstConnect;
    }

    public void setFirstConnect(String firstConnect) {
        this.firstConnect = firstConnect;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSecondConnect() {
        return secondConnect;
    }

    public void setSecondConnect(String secondConnect) {
        this.secondConnect = secondConnect;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    /*public TimerItem(int hour, String firstConnect, int minute, String secondConnect, int second){
        this.hour = hour;
        this.firstConnect = firstConnect;
        this.minute = minute;
        this.secondConnect = secondConnect;
        this.second = second;
    } */
}
