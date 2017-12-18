package com.example.acer.myapp_p.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yvtc on 2017/11/20.
 */

public class comListDBHelper extends SQLiteOpenHelper {
    static String FILENAME = "com";
    static int version = 1;


    public comListDBHelper(Context context) {
        super(context, FILENAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE  TABLE \"main\".\"com\" (\"_id\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL ," +
                " \"商品名稱\" VARCHAR, \"商品類型\" VARCHAR, \"商品售價\" VARCHAR)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
