package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WriteDiaryActivity extends AppCompatActivity {

    private static final String TAG = "ScheduleMainActivity";
    private TextView thisday;
    private int PICK_CONTACT_REQUEST = 1;
    private ImageView inputPicture;
    private EditText diaryStory;
    private final int PERMISSIONS_REQUEST_RESULT = 100;

    private DiaryAdapter diaryAdapter;
    private LinearLayoutManager linearLayoutManager;
    private DiaryItem diaryItem;

    @SuppressLint("SimpleDateFormat")
    // 날짜를 나타냇 포맷을 정함 ( 원하는대로 형태 변경 가능 )
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.M.d");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_diary);

        // 오늘 날짜를 스케쥴관리메인 액티비티가 만들어질때 출력함
        final Date date = new Date();
        // today 변수에 포맷에 맞게 값을 저장한다.
        String today = dateFormat.format(date);
        Log.d(TAG,"today: date : " + today);
        thisday = (TextView) findViewById(R.id.today);
        thisday.setText(today);

        //취소이미지를 누르면 스케쥴 메인 액티비티로 이동
        ImageButton cancelButton = (ImageButton)findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(WriteDiaryActivity.this, DiaryMainActivity.class);
                startActivity(intent);
            }
        });

        //이미지뷰를 누르면 앨범에서 사진을 선택할 수 있음
        inputPicture = (ImageView)findViewById(R.id.diaryImage);
        inputPicture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                //intent.setType("image/*");
                //intent.setAction(Intent.ACTION_GET_CONTENT);
                //startActivityForResult(intent,101);

                startActivityForResult(intent, PICK_CONTACT_REQUEST);
            }
        });

        diaryStory = (EditText) findViewById(R.id.diaryStory);
        diaryStory.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() >= 300)
                {
                    //글자가 300자 이상이면 아래와 같은 토스트 문구가 뜸
                    Toast.makeText(WriteDiaryActivity.this, "글은 300자 까지 입력 가능합니다.", Toast.LENGTH_SHORT).show();
                }

                if (diaryStory.getLineCount() >= 6)
                {
                    //글자가 300자 이상이면 아래와 같은 토스트 문구가 뜸
                    Toast.makeText(WriteDiaryActivity.this, "글은 최대 6줄 까지 입력 가능합니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //체크이미지를 누르면 다이어리 확인 액티비티로 이동
        ImageButton doneButton = (ImageButton)findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 액티비티 전환 코드
                Intent intent = new Intent(WriteDiaryActivity.this, DiaryMainActivity.class);

                // 날짜 값을 String 값으로 그대로 전달.
                TextView diaryDate = (TextView) findViewById(R.id.today) ;
                intent.putExtra("diaryDate", diaryDate.getText().toString()) ;

                // 다이어리 제목 입력 값을 String 값으로 그대로 전달.
                EditText diaryTitle = (EditText) findViewById(R.id.diaryTitle) ;
                intent.putExtra("diaryTitle", diaryTitle.getText().toString()) ;

                // 장소 입력 값을 String 값으로 그대로 전달.
                EditText spot = (EditText) findViewById(R.id.textSpot) ;
                intent.putExtra("spot", spot.getText().toString()) ;

                // 다이어리 내용 값을 String 값으로 그대로 전달.
                EditText diaryStory = (EditText) findViewById(R.id.diaryStory) ;
                intent.putExtra("diaryStory", diaryStory.getText().toString()) ;

                // 다이어리 앨범 이미지를 전달
                //Uri uri = (Uri) data.getData();
               // intent.putExtra("uri", uri.toString());
                /*BitmapDrawable drawable = (BitmapDrawable) inputPicture.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image",byteArray); */

                /*inputPicture = (ImageView)findViewById(R.id.diaryImage);
                //intent.putExtra("diaryImage", inputPicture.getText().toString())
                //Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.god);
                BitmapDrawable drawable = (BitmapDrawable) inputPicture.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image",byteArray); */

                //DiaryMainActivity.arrayList = new ArrayList<>();
                diaryItem = new DiaryItem(R.drawable.profile_picture, diaryTitle.getText().toString(), diaryDate.getText().toString());
                DiaryMainActivity.arrayList.add(0,diaryItem);
                Log.d(TAG,"WriteDiaryActivity에서 넘겨주는 값" + diaryItem);

                startActivity(intent);
            }
        });
    }

    private String getRealPathFromURI(Uri contentUri) {
        if (contentUri.getPath().startsWith("/storage")) {
            return contentUri.getPath();
        }
        String id = DocumentsContract.getDocumentId(contentUri).split(":")[1];
        String[] columns = { MediaStore.Files.FileColumns.DATA };
        String selection = MediaStore.Files.FileColumns._ID + " = " + id;
        Cursor cursor = getContentResolver().query(MediaStore.Files.getContentUri("external"), columns, selection, null, null);
        try {
            int columnIndex = cursor.getColumnIndex(columns[0]);
            if (cursor.moveToFirst()) {
                return cursor.getString(columnIndex);
            }
        }finally {
            cursor.close();
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Uri selectedImageUri = data.getData();
                inputPicture.setImageURI(selectedImageUri);
            }
        }
    }
}
