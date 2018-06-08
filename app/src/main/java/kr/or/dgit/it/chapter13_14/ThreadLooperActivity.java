package kr.or.dgit.it.chapter13_14;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class ThreadLooperActivity extends AppCompatActivity {

    private Handler handler;
    private ArrayList<String> oddData;
    private ArrayList<String> evenData;
    private ArrayAdapter<String> oddAdapter;
    private ArrayAdapter<String> evenAdapter;
    private OneThread oneThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_looper);
        setTitle(getIntent().getStringExtra("title"));

        //원본
        oddData = new ArrayList<>();
        oddData.add("홀수");
        evenData = new ArrayList<>();
        evenData.add("짝수");

        //어댑터
        oddAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, oddData);
        evenAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, evenData);


        //ListView 참조
        ListView oddListView = findViewById(R.id.oddList);
        ListView evenListView = findViewById(R.id.evenList);

        oddListView.setAdapter(oddAdapter);
        evenListView.setAdapter(evenAdapter);

        handler = new Handler();//activity 핸들러

        //ondThread생성
        oneThread = new OneThread();
        oneThread.start();

        //TwoThread
        TwoThread twoThread = new TwoThread();
        twoThread.start();
    }

    class OneThread extends Thread{
        Handler oneHandler;

        @Override
        public void run() {
            Looper.prepare();

            oneHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {//twoThread에서 전달된 msg
                    SystemClock.sleep(1000);
                    final int data = msg.arg1;
                    if(msg.what==0){//짝수이면
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //데이터 원본에 추가하는거임
                                evenData.add("even : "+data);
                                evenAdapter.notifyDataSetChanged();
                            }
                        });
                    }else{
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //데이터 원본에 추가하는거임
                                oddData.add("odd : "+data);
                                oddAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            };

            Looper.loop();
        }
    }

    class TwoThread extends Thread{
        @Override
        public void run() {
            Random rnd = new Random();
            for(int i=0; i<10; i++){
                SystemClock.sleep(100);
                int data = rnd.nextInt(10);//0부터 9까지
                Message message = Message.obtain();
                message.arg1 = data;
                message.arg2 = i;

                message.what=data%2==0?0:1;

                oneThread.oneHandler.sendMessage(message);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        oneThread.oneHandler.getLooper().quit();
    }
}
