package kr.or.dgit.it.chapter13_14.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, "calldb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String callSQL = "create table tb_call"+
                "(_id integer primary key autoincrement,"+
                "name not null,"+
                "photo,"+
                "date,"+
                "phone)";
        db.execSQL(callSQL);

        db.execSQL("insert into tb_call(name, photo, date, phone) values ('홍길동','yes','휴대전화, 1일전','010001')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('가나다','no','휴대전화, 1일전','010333')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('하하호','yes','휴대전화, 3일전','010331')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('수박씨','no','휴대전화, 1일전','010551')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('씬나씬나','yes','휴대전화, 2일전','010001')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('살구씨','yes','휴대전화, 2일전','010551')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('녹차','no','휴대전화, 1일전','010661')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('둥글레차','no','휴대전화, 5일전','010881')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('홍길동','no','휴대전화, 1일전','010001')");
        db.execSQL("insert into tb_call(name, photo, date, phone) values ('체리씨','no','휴대전화, 4일전','010001')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion==DATABASE_VERSION){
            db.execSQL("drop table tb_call");
            onCreate(db);
        }
    }


}
