package kr.or.dgit.it.chapter13_14;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {

    private TextView textView;
    private AsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);
        setTitle(getIntent().getStringExtra("title"));

        textView = findViewById(R.id.main_textView);

    }

    public void startBtn(View view) {
        new MyAsyncTask().execute();
    }

    public void pauseBtn(View view) {

    }


    class MyAsyncTask extends AsyncTask<Void, Integer, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(AsyncTaskActivity.this,"onPreExecute()",Toast.LENGTH_LONG).show();
            textView.setText("onPreExecute");
        }

        @Override
        protected String doInBackground(Void... voids) {


            for(int i=0; i<5; i++){
                publishProgress(i);
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Finish";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
         //   Toast.makeText(AsyncTaskActivity.this, "onPostExecute()"+s, Toast.LENGTH_LONG).show();
            textView.setText(s);
        }
    }
}
