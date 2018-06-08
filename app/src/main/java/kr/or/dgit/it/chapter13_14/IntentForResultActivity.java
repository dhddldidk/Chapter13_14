package kr.or.dgit.it.chapter13_14;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.or.dgit.it.chapter13_14.db.DBHelper;

public class IntentForResultActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 10;//상수로 선언됨
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> datas;
    private String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_for_result);
        setTitle(getIntent().getStringExtra("title"));

        //원본 db에서 select한 결과를 가져와야함
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();//여기까지가 연결한거임
        Cursor cursor = db.rawQuery("select location from tb_data where category='0'", null);
        datas = new ArrayList<>(); // select 한 결과를 arrayList에 담은거임

        while (cursor.moveToNext()){
            datas.add(cursor.getString(0));//커서에서 0번째인 location을 가져옴
        }
        db.close();

        //adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,datas);

        //listView
        listView = findViewById(R.id.addrList);
        listView.setAdapter(adapter); // listView에 목록만 보임
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //listView에 목록을 클릭했을때
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
               category = tv.getText().toString();//view에 들어있는 글자를 가져옴
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);//명시적으로 수행해야할 activity이름 알려줌
                intent.putExtra("category", category);//카테고리를 실어서 보냄(정보를 넣어줌)
                startActivityForResult(intent, REQUEST_CODE);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            String location = category+data.getStringExtra("location"); //location으로 전달받아서
            Toast.makeText(this,location,Toast.LENGTH_LONG).show();//토스트에 띄우기
        }
    }
}
