package kr.or.dgit.it.chapter13_14;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeStyleActivity extends AppCompatActivity {
    private static final String TAG = "LifeCycleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Log.d(TAG, "parent  -  onCreate :");
        super.onCreate(savedInstanceState);
        setTitle(getIntent().getStringExtra("title"));

        Button btn = new Button(this);
        btn.setText("SubActivity");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });
        setContentView(btn);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "parent  -  onStart :");
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "parent  -  onSaveInstanceState(Bundle) :");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d(TAG, "parent  -  onSaveInstanceState(Bundle, PersistableBundle ) :");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "parent  -  onRestoreInstanceState(Bundle) :");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        Log.d(TAG, "parent  -  onRestoreInstanceState(Bundle, PersistableBundle) :");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "parent  -  onPause :");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "parent  -  onResume :");
        super.onResume();
    }



    @Override
    protected void onStop() {
        Log.d(TAG, "parent  -  onStop :");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "parent  -  onDestroy :");
        super.onDestroy();
    }
}
