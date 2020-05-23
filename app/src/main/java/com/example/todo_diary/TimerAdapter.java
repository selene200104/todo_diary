package com.example.todo_diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TimerAdapter extends BaseAdapter {

    private TextView tvHour;
    private TextView tvFirstConnect;
    private TextView tvMinute;
    private TextView tvSecondConnect;
    private TextView tvSecond;

    private ArrayList<TimerItem> listViewItemList = new ArrayList<TimerItem>();

    public TimerAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_timer_item, parent, false);
        }

        tvHour = (TextView) convertView.findViewById(R.id.hour);
        tvFirstConnect = (TextView) convertView.findViewById(R.id.firstConnect);
        tvMinute = (TextView) convertView.findViewById(R.id.minute);
        tvSecondConnect = (TextView) convertView.findViewById(R.id.secondConnect);
        tvSecond = (TextView) convertView.findViewById(R.id.second);

        TimerItem listViewItem = listViewItemList.get(position);

        tvHour.setText(listViewItem.getHour());
        tvFirstConnect.setText(listViewItem.getFirstConnect());
        tvMinute.setText(listViewItem.getMinute());
        tvSecondConnect.setText(listViewItem.getSecondConnect());
        tvSecond.setText(listViewItem.getSecond());

        return convertView;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    public void addItem(String hour, String firstConnect, String minute, String secondConnect, String second){
        TimerItem item = new TimerItem();
        item.setHour(hour);
        item.setFirstConnect(firstConnect);
        item.setMinute(minute);
        item.setSecondConnect(secondConnect);
        item.setSecond(second);

        listViewItemList.add(item);
    }

} /*extends BaseAdapter {

    private ArrayList<TimerItem> mItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public TimerItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();
    }
/*extends BaseAdapter {
            // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
            private ArrayList<TimerItem> listViewItemList = new ArrayList<TimerItem>() ;

            // ListViewAdapter의 생성자
    public TimerAdapter() {

            }

            // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
            @Override
            public int getCount() {
                return listViewItemList.size() ;
            }

            // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final int pos = position;
                final Context context = parent.getContext();

                // "listview_item" Layout을 inflate하여 convertView 참조 획득.
                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.activity_timer_item, parent, false);
                }

                // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
                TextView tv_hour = (TextView) convertView.findViewById(R.id.hour) ;
                TextView tv_minute = (TextView) convertView.findViewById(R.id.minute) ;
                TextView tv_second = (TextView) convertView.findViewById(R.id.second) ;

                // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
                TimerItem listViewItem = listViewItemList.get(position);

                // 아이템 내 각 위젯에 데이터 반영
                tv_hour.setText(listViewItem.getHour());
                tv_minute.setText(listViewItem.getMinute());
                tv_second.setText(listViewItem.getSecond());

                return convertView;
            }

            // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
            @Override
            public long getItemId(int position) {
                return position ;
            }

            // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
            @Override
            public Object getItem(int position) {
                return listViewItemList.get(position) ;
            }

            // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
            public void addItem(String hour, String minute, String second) {
                TimerItem item = new TimerItem();

                item.setHour(hour);
                item.setMinute(minute);
                item.setSecond(second);

                listViewItemList.add(item);
            }

    public void addItem(TimerItem timerItem) {
    }*/
//}
