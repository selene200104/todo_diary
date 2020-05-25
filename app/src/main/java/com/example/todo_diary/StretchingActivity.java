package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StretchingActivity extends AppCompatActivity {

    int stretchingTimeMax = 6;
    int[] stretchingTimeImgs = new int[stretchingTimeMax];
    ArrayList<String> wiseSaying = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);

        //스트레칭 타임 이미지를 배열에 넣어줌
        for (int i = 0; i < stretchingTimeMax; i++) {
            stretchingTimeImgs[i] = getApplicationContext().getResources().getIdentifier( "minute"+i, "drawable", "com.example.todo_diary");
        }

        ImageView minuteImage = (ImageView) findViewById(R.id.timeImage);
        minuteImage.setImageResource(stretchingTimeImgs[stretchingTimeMax-1]);

        //명언배열에 값을 넣어줌
        wiseSaying.add("“뛰어남이란 항상 더 잘 하려고 노력하는 데에서 나온 꾸준한 결과이다.” -Pat Riley");
        wiseSaying.add("“긴 인내 후의 실패는 충분히 노력하지 않은 것보다 훨씬 더 위대하다.” -George Eliot");
        wiseSaying.add("“성공의 이전에는 노력이 있음을 항상 기억하라. 심지어 사전에서도 그렇다.” -Sarah Ban Breathnach");
        wiseSaying.add("“당신의 최대 기적에 가장 가까울 때, 당신은 가장 최대 역경을 마주하게 될 것이다.” -Shannon L. Alder");
        wiseSaying.add("“천리길도 한 걸음부터.” -Lao Tzu");
        wiseSaying.add("“나는 실패한 적이 없다. 그저 작동하지 않는 10,000개의 방법들을 발견했을 뿐이다.” –Thomas A. Edison");
        wiseSaying.add("“질문은 누가 나를 허락하는가가 아니라, 누가 나를 멈추게 할 것인가이다.” -Ayn Rand");
        wiseSaying.add(" “이 세상에서 당신은 오직 당신이 잡으려고 손을 뻗은 것만을 얻는다.” -Giovanni Boccaccio");
        wiseSaying.add("“모든 스트라이크는 나를 다음 홈런에 한층 더 가깝게 해준다.” -Babe Ruth");
        wiseSaying.add(" “성공하기 전에는 항상 그것이 불가능한 것처럼 보이기 마련이다.” -Nelson Mandela");

        TextView wiseSayingText = (TextView) findViewById(R.id.stressText) ;
        wiseSayingText.setText(wiseSaying.get(9));
    }
}
