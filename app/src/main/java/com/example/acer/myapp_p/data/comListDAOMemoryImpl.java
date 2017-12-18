package com.example.acer.myapp_p.data;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/11/13.
 */

public class comListDAOMemoryImpl implements comListDAO {
    ArrayList<comList> data = new ArrayList();
    int MaxID = 1;
    @Override
    public void add(comList s) {
        s.id = MaxID;
        data.add(s);
        MaxID++;
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

            }
        }
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
    }


    @Override
    public void clear() {
        data.clear();
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
