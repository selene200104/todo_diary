package com.example.todo_diary;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static java.nio.file.Files.delete;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.CustomViewHolder> {

    private ArrayList<DiaryItem> arrayList;

    public DiaryAdapter(ArrayList<DiaryItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public DiaryAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_diary_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    //실행될 때
    @Override
    public void onBindViewHolder(@NonNull final DiaryAdapter.CustomViewHolder holder, int position) {
        holder.picture.setImageResource(arrayList.get(position).getPicture());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.date.setText(arrayList.get(position).getDate());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = holder.title.getText().toString();
                Toast.makeText(v.getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView picture;
        protected TextView title;
        protected TextView date;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.picture = (ImageView) itemView.findViewById(R.id.diary_picture);
            this.title = (TextView) itemView.findViewById(R.id.diary_title);
            this.date = (TextView) itemView.findViewById(R.id.diary_date);
        }
    }
}
