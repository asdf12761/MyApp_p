package com.example.acer.myapp_p.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by yvtc on 2017/11/15.
 */

public class comListDAOFileImpl implements comListDAO {
    ArrayList<comList> data;
    Context context;
    int MaxID;
    String DATA_FILE;
    public comListDAOFileImpl(Context context)
    {
        this.context = context;
        DATA_FILE = context.getFilesDir().getAbsolutePath() + File.separator + "mydata.json";
        data = new ArrayList<>();
        loadData();
    }

    private void saveData()
    {
        try {
            FileWriter fw = new FileWriter(DATA_FILE);
            Gson gson = new Gson();
            String str = gson.toJson(data);
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData()
    {
        try {
            FileReader fr = new FileReader(DATA_FILE);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            br.close();
            fr.close();
            System.out.println("string:" + str);
            if (str.trim().length() > 0)
            {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<comListDAO>>() {}.getType();
                data = gson.fromJson(str, listType);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.size() > 0)
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
        MaxID += 1;
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
        return data.toArray(new comList[data.size()]);
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
        ArrayList<comList> tmpList = new ArrayList<>();
        for (comList tmp : data)
        {
            if (tmp.商品名稱.equals(name))
            {
                tmpList.add(tmp);
            }
        }
        return tmpList.toArray(new comList[tmpList.size()]);
    }
}
