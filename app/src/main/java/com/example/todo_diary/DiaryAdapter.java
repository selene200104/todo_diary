package com.example.todo_diary;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static java.nio.file.Files.delete;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.CustomViewHolder> {

    private static final String TAG = "ScheduleMainActivity";
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
    public void onBindViewHolder(@NonNull final DiaryAdapter.CustomViewHolder holder, final int position) {
        holder.picture.setImageResource(arrayList.get(position).getPicture());
        holder.title.setText(arrayList.get(position).getTitle());
        holder.date.setText(arrayList.get(position).getDate());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = holder.title.getText().toString();
                Toast.makeText(v.getContext(), name, Toast.LENGTH_SHORT).show();

                //리사이클러뷰를 클릭하면 다이어리확인액티비티로 이동
                Intent intent = new Intent(v.getContext(),CheckDiaryActivity.class);
                intent.putExtra("diaryDate", arrayList.get(position).getDate());
                Log.d(TAG,"diaryDate값 " + arrayList.get(position).getDate());
                intent.putExtra("diaryTitle", arrayList.get(position).getTitle());
                Log.d(TAG,"diaryTitle값 " + arrayList.get(position).getTitle());
                intent.putExtra("spot", arrayList.get(position).getSpot());
                Log.d(TAG,"spot값 " + arrayList.get(position).getSpot());
                intent.putExtra("diaryStory", arrayList.get(position).getDiaryText());
                Log.d(TAG,"diaryStory값 " + arrayList.get(position).getDiaryText());
                v.getContext().startActivity(intent);
            }
        });

        //길게 누르면 다이어로그가 뜨면서 삭제할건지 물어봄
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                String name = holder.title.getText().toString();
                Toast.makeText(v.getContext(), name, Toast.LENGTH_SHORT).show();

                final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("[ "+name+" ]를 삭제하시겠어요?");
                builder.setMessage("삭제하시려면 '네'를 선택해주세요.");
                builder.setPositiveButton("네",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, arrayList.size());
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
                return false;
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
