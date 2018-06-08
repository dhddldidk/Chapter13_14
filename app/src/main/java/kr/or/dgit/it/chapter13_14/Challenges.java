package kr.or.dgit.it.chapter13_14;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import kr.or.dgit.it.chapter13_14.database.DBHelper;

public class Challenges extends AppCompatActivity {

    boolean callPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        setTitle(getIntent().getStringExtra("title"));

        /*Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel : "+vo.phone));
        getApplicationContext().startActivity(intent);*/

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            callPermission=true;
        }

        if(!callPermission){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 200);
        }

        ListView listView=(ListView)findViewById(R.id.call_list);
        ArrayList<CallVO> datas=new ArrayList<>();

        DBHelper helper=new DBHelper(this);
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select name, photo, date, phone from tb_call", null);
        while (cursor.moveToNext()){
            CallVO vo=new CallVO();
            vo.name=cursor.getString(0);
            vo.photo=cursor.getString(1);
            vo.date=cursor.getString(2);
            vo.phone=cursor.getString(3);
            datas.add(vo);
        }
        db.close();

        CallAdapter adapter=new CallAdapter(this, R.layout.call_list, datas);
        listView.setAdapter(adapter);
    }

}
