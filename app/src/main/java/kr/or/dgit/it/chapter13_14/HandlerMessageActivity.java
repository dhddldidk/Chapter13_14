package kr.or.dgit.it.chapter13_14;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HandlerMessageActivity extends AppCompatActivity {

    private TextView textView;
    private boolean loopFlag;
    private boolean isRun;
    private MyThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);
        setTitle(getIntent().getStringExtra("title"));

        textView = findViewById(R.id.main_textView);
        loopFlag = true;

        thread = new MyThread();
    }

    public void startBtn(View view) {
        isRun=true;
        thread.start();
    }

    public void pauseBtn(View view) {
        isRun=false;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1){
                textView.setText(String.valueOf(msg.arg1));
            }else if(msg.what==2){
                textView.setText((String) msg.obj);
            }
        }
    };

    class MyThread extends Thread {
        public void run(){
            try{
                int count=10;
                Message msg;

                while(loopFlag){ //loopFlag는 true
                    Thread.sleep(1000);
                    if(isRun){ //isRun은 false
                      count--;
                      if(count == 0){
                          msg = Message.obtain(handler, 2, "finish");
                          loopFlag=false;
                      }else{
                          msg = Message.obtain(handler, 1);
                          msg.arg1 = count;
                      }
                     handler.sendMessage(msg);
                    }
                }
            }catch (Exception e){

            }
        }
    }

}
