import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todo_diary.DiaryItem;

import java.util.ArrayList;

public class DiarylistviewAdapter {

    /*private static final android.R.attr R = ;
    private ArrayList<DiaryItem> listCustom = new ArrayList<>();

    // ListView에 보여질 Item 수
    @Override
    public int getCount() {
        return listCustom.size();
    }

    // 하나의 Item(ImageView 1, TextView 2)
    @Override
    public Object getItem(int position) {
        return listCustom.get(position);
    }

    // Item의 id : Item을 구별하기 위한 것으로 position 사용
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 실제로 Item이 보여지는 부분
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, null, false);

            holder = new CustomViewHolder();
            holder.diary_picture = (ImageView) convertView.findViewById(R.id.diary_picture);
            holder.diary_title = (TextView) convertView.findViewById(R.id.diary_title);
            holder.diary_date = (TextView) convertView.findViewById(R.id.diary_date);

            convertView.setTag(holder);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        DiaryItem diaryItem = listCustom.get(position);

        holder.diary_picture.setImageResource(diaryItem.getPicture());
        holder.diary_title.setText(diaryItem.getTitle());
        holder.diary_date.setText(diaryItem.getDate());

        return convertView;
    }

    class CustomViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textContent;
    }

    // MainActivity에서 Adapter에있는 ArrayList에 data를 추가시켜주는 함수
    public void addItem(DiaryItem diaryItem) {
        listCustom.add(diaryItem);
    } */
}
