package com.example.acer.myapp_p;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.acer.myapp_p.data.comList;

public class ItenActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    comList stu;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iten);
        tv1 =(TextView) findViewById(R.id.tv_name_i);
        tv2 =(TextView) findViewById(R.id.tv_type_i);
        tv3 =(TextView) findViewById(R.id.tv_price_i);
        tv4 =(TextView) findViewById(R.id.tv_sprice_i);
        tv5 =(TextView) findViewById(R.id.tv_rtype2_i);
        tv6 = (TextView) findViewById(R.id.tv_id);
        id = getIntent().getIntExtra("id", -1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        stu = ListActivity.t.getOneStudent(id);
        tv6.setText(String.valueOf(stu.id)+"號商品:");
        tv1.setText(stu.商品名稱);
        tv2.setText(stu.商品類型);
        tv3.setText(stu.商品售價);
        tv4.setText(stu.商品特價);
        tv5.setText(stu.商品數量);
    }

}
