package com.example.acer.myapp_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.acer.myapp_p.data.comList;

public class EditActivity extends AppCompatActivity {
    int id;
    comList com;
    EditText et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        et1 = (EditText) findViewById(R.id.et_name);
        et2 = (EditText) findViewById(R.id.et_type);
        et3 = (EditText) findViewById(R.id.et_price);
        et4 = (EditText) findViewById(R.id.et_sprice);
        et5 = (EditText) findViewById(R.id.et_type2);
        id = getIntent().getIntExtra("id", -1);
        com = ListActivity.t.getOneStudent(id);
        et1.setText(com.商品名稱);
        et2.setText(com.商品類型);
        et3.setText(com.商品售價);
        et4.setText(com.商品特價);
        et5.setText(com.商品數量);
    }

    private void update(View v){
        com.商品名稱 = et1.getText().toString();
        com.商品類型 = et2.getText().toString();
        com.商品售價 = et3.getText().toString();
        com.商品特價 = et4.getText().toString();
        com.商品數量 = et5.getText().toString();
        ListActivity.t.update(com);
        finish();
    }

    private void rstart(View v){
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
    }

    private void back(View v){
        finish();
    }
}
