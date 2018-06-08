package kr.or.dgit.it.chapter13_14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class StepByStep extends AppCompatActivity {

    private static final String TAG = "StepByStep";

    ListView listView;
    ArrayList<String> datas;
    ArrayAdapter<String> adapter;

    Button detailBtn;
    Button dialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "parent  -  onCreate :");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_by_step);
        setTitle(getIntent().getStringExtra("title"));

        listView = findViewById(R.id.main_list);
        detailBtn = findViewById(R.id.goDetail);
        dialogBtn = findViewById(R.id.goDialog);

        datas=new ArrayList<>();

        datas.add("parent  -  onCreate....");

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
    }


    public void goDetail(View view) {
        Intent intent = new Intent(this, DetailActivity2.class);
        startActivity(intent);

    }

    public void goDialog(View view) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "parent  -  onStart :");
        super.onStart();
        datas.add("parent  -  onStart...");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "parent  -  onResume :");
        super.onResume();
        datas.add("parent  -  onResume");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "parent  -  onPause :");
        super.onPause();
        datas.add("parent  -  onPause");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "parent  -  onStop :");
        super.onStop();
        datas.add("parent  -  onStop");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "parent  -  onDestroy :");
        super.onDestroy();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "parent  -  onSaveInstanceState :");
        super.onSaveInstanceState(outState);
        datas.add("parent  -  onSaveInstanceState");
        adapter.notifyDataSetChanged();

    }
}
