package com.example.todo_diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class scheduleAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<scheduleItem> scheduleItem;

    /*public scheduleAdapter(Context context, ArrayList<scheduleItem> data) {
        mContext = context;
        scheduleItem = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    } */
    public scheduleAdapter(ArrayList<scheduleItem> arrayList) {
        this.scheduleItem = arrayList;
    }

    @Override
    public int getCount() {
        return scheduleItem.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.activity_schedule_item, null);

        TextView movieName = (TextView)view.findViewById(R.id.scheduleText);
        movieName.setText(scheduleItem.get(position).getScheduleText());

        return view;
    }

    @Override
    public scheduleItem getItem(int position) {
        return scheduleItem.get(position);
    }
}
