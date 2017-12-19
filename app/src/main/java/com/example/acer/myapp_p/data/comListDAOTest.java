package com.example.acer.myapp_p.data;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/11/13.
 */

public class comListDAOTest {
    ArrayList<comList> data = new ArrayList();
    int MaxID = 1;
    public void add(comList s)
    {
        s.id = MaxID;
        data.add(s);
        MaxID++;
    }

    public ArrayList<comList> getData()
    {
        return data;
    }
    public void update(comList s)
    {
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
    }
}
