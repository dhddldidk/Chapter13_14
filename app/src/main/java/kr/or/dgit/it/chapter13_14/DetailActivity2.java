package kr.or.dgit.it.chapter13_14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity2 extends AppCompatActivity {

    private static final String TAG = "DetailActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "Detail  -  onCreate :");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Detail  -  onStart :");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Detail  -  onResume :");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Detail  -  onPause :");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Detail  -  onStop :");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Detail  -  onDestroy :");
        super.onDestroy();
    }
}
