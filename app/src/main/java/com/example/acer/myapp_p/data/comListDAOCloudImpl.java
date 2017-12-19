package com.example.acer.myapp_p.data;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by yvtc on 2017/12/4.
 */

public class comListDAOCloudImpl implements comListDAO {
    ArrayList<comList> data = new ArrayList<>();
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;
    final String TAG = "CloudImpl";
    int MaxID;
    public comListDAOCloudImpl(final Context context)
    {
        this.context = context;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("studentdata");
        // Read from the database
        Log.d(TAG, "In Cloud Constructor");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "Start to get data");
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<comList>>() {}.getType();
                data = gson.fromJson(value, listType);
                if (data!=null)
                {
                    if (data != null && data.size() > 0)
                    {
                        MaxID = data.get(0).id;
                    }
                    for (comList s : data)
                    {
                        if (MaxID < s.id)
                        {
                            MaxID = s.id;
                        }
                    }
                }
                else
                {
                    data = new ArrayList<>();
                }

                MaxID += 1;
                Log.d(TAG, "Value is: " + value);
                ((OnCloudReceivedListener) context).onReceivedEvent();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void saveData()
    {
        Gson gson = new Gson();
        String str = gson.toJson(data);
        myRef.setValue(str);
    }

    @Override
    public void add(comList s) {
        s.id = MaxID;
        data.add(s);
        MaxID++;
        saveData();
    }

    @Override
    public comList[] getData() {
        if (data != null)
        {
            return data.toArray(new comList[data.size()]);
        }
        else
        {
            new ArrayList();
        }
        return null;

    }

    @Override
    public void update(comList s) {
        for (comList tmp : data)
        {
            if (tmp.id == s.id)
            {
                tmp.商品名稱 = s.商品名稱;
                tmp.商品類型 = s.商品類型;
                tmp.商品售價 = s.商品售價;
                tmp.商品特價 = s.商品特價;
                tmp.商品數量 = s.商品數量;
                tmp.comNow = s.comNow;
                tmp.img = s.img;
            }
        }
        saveData();
    }

    @Override
    public void delete(comList s) {
        for (int i=data.size()-1;i>=0;i--)
        {
            if (data.get(i).id == s.id)
            {
                data.remove(i);
                break;
            }
        }
        saveData();
    }

    @Override
    public void clear() {
        data.clear();
        saveData();
    }

    @Override
    public comList getOneStudent(int id) {
        for (comList tmp : data)
        {
            if (tmp.id == id)
            {
                return tmp;
            }
        }
        return null;
    }

    @Override
    public comList[] searchByName(String name) {
        return new comList[0];
    }
}
