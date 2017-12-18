package com.example.acer.myapp_p.data;

/**
 * Created by yvtc on 2017/11/13.
 */

public class comList {
    public int id;
    public String 商品名稱;
    public String 商品類型;
    public String 商品售價;
    public String 商品特價;
    public String 商品數量;

    public comList(String rname,String rtype,String rprice,String rsprice,String rtype2)
    {
        this.商品名稱 = rname;
        this.商品類型 = rtype;
        this.商品售價 = rprice;
        this.商品特價 = rsprice;
        this.商品數量 = rtype2;
    }
    public comList(int id, String rname,String rtype,String rprice,String rsprice,String rtype2)
    {
        this.id = id;
        this.商品名稱 = rname;
        this.商品類型 = rtype;
        this.商品售價 = rprice;
        this.商品特價 = rsprice;
        this.商品數量 = rtype2;
    }

    @Override
    public String toString()
    {
        return id + "," + 商品名稱 + "," + 商品類型 + "," + 商品售價 + "," + 商品特價 + ","+ 商品數量;
    }
}
