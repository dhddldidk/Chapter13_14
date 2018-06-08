package kr.or.dgit.it.chapter13_14;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DialogActivity extends Activity {

    private static final String TAG = "DialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Dialog  -  onCreate :");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void finishDialog(View view) {
        DialogActivity.this.finish();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Dialog  -  onStart :");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Dialog  -  onResume :");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Dialog  -  onPause :");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Dialog  -  onStop :");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Dialog  -  onDestroy :");
        super.onDestroy();
    }
}
