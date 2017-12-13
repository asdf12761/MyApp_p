package com.example.acer.myapp_p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDB_List extends MyDB_com {
    private final static String DATABASE_NAME = "list.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "Dental_Clinics";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME +" ( `_id` INTEGER, `name` TEXT, PRIMARY KEY(`_id`) );";

    private Context mCtx;
    private DataBaseOpenHelper helper;
    private SQLiteDatabase db;

    public MyDB_List(Context context) {
        mCtx = context;
    }

    public MyDB_com open() {
        helper = new DataBaseOpenHelper(mCtx);
        db = helper.getReadableDatabase();
        return this;
    }

    private class DataBaseOpenHelper extends SQLiteOpenHelper {

        public DataBaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    private static final String KEY_ROWID = "_id";
    private static final String KEY_1 = "name";


    String[] strCols = {KEY_ROWID, KEY_1};

    public Cursor getAll() {
        return db.query(TABLE_NAME, strCols, null, null, null, null, null);
    }

    public Cursor get(long rowId) throws SQLException {
        Cursor mCursor = db.query(true,
                TABLE_NAME,
                strCols,
                KEY_ROWID + "=" + rowId,
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }

        return mCursor;
    }

    public long create(String name) {
        ContentValues args = new ContentValues();
        args.put(KEY_1, name);
        Log.d("mylog","add："+ name);
//        args.put(KEY_NOTE, noteName);
//        args.put(KEY_CREATED, now.getTime());
        return db.insert(TABLE_NAME, null, args);
    }

    public boolean delete(long rowId) {
        return db.delete(TABLE_NAME, KEY_ROWID + "=" + rowId, null) > 0;
    }

    public boolean update(long rowId, String name) {
        ContentValues args = new ContentValues();
        args.put(KEY_1, name);
        Log.d("mylog","updata："+ rowId);
        Log.d("mylog","updata："+ name);
        return db.update(TABLE_NAME, args, KEY_ROWID + "=" + rowId, null) > 0;
    }



}
