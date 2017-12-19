package com.example.acer.myapp_p.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/11/20.
 */

public class comListDAODBImpl implements comListDAO {
    Context context;
    comListDBHelper helper;
    SQLiteDatabase db;
    public comListDAODBImpl(Context context)
    {
        this.context = context;
        helper = new comListDBHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public void add(comList s) {
        ContentValues cv = new ContentValues();
        cv.put("rname", s.商品名稱);
        cv.put("rtype", s.商品類型);
        cv.put("rprice", s.商品售價);
        cv.put("rsprice", s.商品特價);
        cv.put("rtype2", s.商品數量);
        cv.put("comNows", s.comNow);
        cv.put("imgurl", s.img);
        db.insert("com", null, cv);
    }

    @Override
    public comList[] getData() {
        ArrayList<comList> tmpList = new ArrayList<>();
        Cursor c = db.query("com", new String[] {"_id", "rname", "rtype", "rprice","rsprice","rtype2","comNows","imgurl"}, null, null, null, null ,null);
        if (c.moveToFirst())
        {
            tmpList.add(new comList(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7)));
            while(c.moveToNext())
            {
                tmpList.add(new comList(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7)));
            }
        }
        return tmpList.toArray(new comList[tmpList.size()]);
    }

    @Override
    public void update(comList s) {
        ContentValues cv = new ContentValues();
        cv.put("rname", s.商品名稱);
        cv.put("rtype", s.商品類型);
        cv.put("rprice", s.商品售價);
        cv.put("rsprice", s.商品特價);
        cv.put("rtype2", s.商品數量);
        cv.put("comNows", s.comNow);
        cv.put("imgurl", s.img);
        db.update("com", cv, "_id=?", new String[] {String.valueOf(s.id)});
    }

    @Override
    public void delete(comList s) {
        db.delete("com", "_id=?", new String[] {String.valueOf(s.id)});
    }

    @Override
    public void clear() {
        db.delete("com", null, null);
    }

    @Override
    public comList getOneStudent(int id) {
        Cursor c = db.query("com", new String[] {"_id", "rname", "rtype", "rprice","rsprice","rtype2","comNows","imgurl"}, "_id=?", new String[] {String.valueOf(id)}, null, null ,null);
        if (c.moveToFirst())
        {
            comList s = new comList(c.getInt(0), c.getString(1), c.getString(2), c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7));
            return s;
        }
        return null;
    }

    @Override
    public comList[] searchByName(String name) {
        return new comList[0];
    }
}
