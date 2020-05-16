import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_diary.CheckDiaryActivity;
import com.example.todo_diary.R;

public class DiaryRecyclerView extends RecyclerView.Adapter<DiaryRecyclerView.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView diaryTitle;
        public TextView diaryDate;

        public ViewHolder(View view) {
            super(view);
            this.diaryTitle = view.findViewById(R.id.diary_title);
            this.diaryDate = view.findViewById(R.id.diary_date);
            this.imageView = view.findViewById(R.id.diary_picture);
        }
    }

        @Override
        public DiaryRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_diary_item, parent, false);
            DiaryRecyclerView.ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

    @Override
    public void onBindViewHolder(DiaryRecyclerView.ViewHolder holder, final int position) {
        int[] title = new int[0];
        holder.diaryTitle.setText(title[position]);
        int[] content = new int[0];
        holder.diaryDate.setText(content[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position+"번 째 이미지!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.diaryTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Test!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.diaryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position+"번 째!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*@Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }*/

    @Override
    public int getItemCount() {
        return 0;
    }
}
