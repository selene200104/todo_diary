package com.example.todo_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StretchingActivity extends AppCompatActivity {

    private static Handler mHandler;

    TextView wiseSayingText;
    int stretchingTimeCount = 0;
    int stretchingTimeMax = 6;
    int stretchingTime = stretchingTimeMax;
    int[] stretchingTimeImgs = new int[stretchingTimeMax];
    ArrayList<String> wiseSaying = new ArrayList<>();
    int wiseSayingPosition = 0;
    boolean isStopStretchingTimer ;
    boolean isStopWiseSaying ;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretching);

        //스트레칭 타임 이미지를 배열에 넣어줌
        for (int i = 0; i < stretchingTimeMax; i++) {
            stretchingTimeImgs[i] = getApplicationContext().getResources().getIdentifier("minute" + i, "drawable", "com.example.todo_diary");
        }

        final ImageView minuteImage = (ImageView) findViewById(R.id.timeImage);
        minuteImage.setImageResource(stretchingTimeImgs[stretchingTimeMax - 1]);

        //명언배열에 값을 넣어줌
        wiseSaying.add("“뛰어남이란 항상 더 잘 하려고 노력하는 데에서 나온 꾸준한 결과이다.” -Pat Riley");
        wiseSaying.add("“긴 인내 후의 실패는 충분히 노력하지 않은 것보다 훨씬 더 위대하다.” -George Eliot");
        wiseSaying.add("“성공의 이전에는 노력이 있음을 항상 기억하라. 심지어 사전에서도 그렇다.” -Sarah Ban Breathnach");
        wiseSaying.add("“당신의 최대 기적에 가장 가까울 때, 당신은 가장 최대 역경을 마주하게 될 것이다.” -Shannon L. Alder");
        wiseSaying.add("“천리길도 한 걸음부터.” -Lao Tzu");
        wiseSaying.add("“나는 실패한 적이 없다. 그저 작동하지 않는 10,000개의 방법들을 발견했을 뿐이다.” –Thomas A. Edison");
        wiseSaying.add("“질문은 누가 나를 허락하는가가 아니라, 누가 나를 멈추게 할 것인가이다.” -Ayn Rand");
        wiseSaying.add("“이 세상에서 당신은 오직 당신이 잡으려고 손을 뻗은 것만을 얻는다.” -Giovanni Boccaccio");
        wiseSaying.add("“모든 스트라이크는 나를 다음 홈런에 한층 더 가깝게 해준다.” -Babe Ruth");
        wiseSaying.add("“성공하기 전에는 항상 그것이 불가능한 것처럼 보이기 마련이다.” -Nelson Mandela");

        wiseSayingText = (TextView) findViewById(R.id.stressText);
        wiseSayingText.setText(wiseSaying.get(0));
        Log.d(" StretchingActivity ", "stretching 초기세팅 " + wiseSaying.get(wiseSayingPosition));

        final Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                //Log.d(" StretchingActivity ", "스트레칭 시작버튼 누름");
                Thread wiseSayingThread = new Thread(new NewRunnable());
                wiseSayingThread.start();

                StretchingTimerThread timer = new StretchingTimerThread();
                timer.start();
                //Log.d(" StretchingActivity ", "stretchingTimer 값 " + stretchingTimeMax);
            }
        });

        mHandler = new Handler() {
            @SuppressLint("SetTextI18n")
            @Override
            public void handleMessage(Message msg) {
                wiseSayingText.setText(wiseSaying.get(wiseSayingPosition));
                Log.d(" StretchingActivity ", "stretching 명언 " + wiseSaying.get(wiseSayingPosition));

                minuteImage.setImageResource(stretchingTimeImgs[stretchingTimeMax]);
                Log.d(" StretchingActivity ", "stretching 시간 " + stretchingTimeMax);

                if(stretchingTimeMax == 0) {
                    startButton.setVisibility(View.VISIBLE);
                }
            }
        };
    }

    public class StretchingTimerThread extends Thread{
        @Override
        public void run() {
            while (stretchingTimeMax != 0) {
                if(stretchingTimeMax > 0){
                    stretchingTimeCount++;
                    Log.d(" StretchingActivity ", "stretchingTimeCount 값 :"+stretchingTimeCount);
                    stretchingTimeMax--;
                    Log.d(" StretchingActivity ", "stretchingTimeMax 쓰레드 값 :"+stretchingTimeMax);
                }else{
                    Log.d(" StretchingActivity ", "stretchingTimer 가 종료되었습니다");
                }
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(0) ;
            }
        }

        public void interrupt() {
            isStopStretchingTimer = true;
        }
    }

    public class NewRunnable implements Runnable {
        @Override
        public void run() {
            while (stretchingTimeCount < 6) {
                if (wiseSayingPosition < wiseSaying.size() - 1) {
                    Log.d(" StretchingActivity ", "버튼 누른 후 stretching 명언 " + wiseSaying.get(wiseSayingPosition));
                    wiseSayingPosition++;
                } else {
                    Log.d(" StretchingActivity ", "한바퀴 돈 후 stretching 명언 " + wiseSaying.get(wiseSayingPosition));
                    wiseSayingPosition = 0;
                }
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(0) ;
            }
        }
    }
}
