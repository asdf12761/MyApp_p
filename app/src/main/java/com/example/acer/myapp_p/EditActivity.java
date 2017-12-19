package com.example.acer.myapp_p;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.acer.myapp_p.data.comList;

public class EditActivity extends AppCompatActivity {
    String comNow = "";
    int id;
    comList com;
    EditText et1,et2,et3,et4,et5;
    private RadioButton on,off,lod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        et1 = (EditText) findViewById(R.id.et_name);
        et2 = (EditText) findViewById(R.id.et_type);
        et3 = (EditText) findViewById(R.id.et_price);
        et4 = (EditText) findViewById(R.id.et_sprice);
        et5 = (EditText) findViewById(R.id.et_type2);
        on=(RadioButton)findViewById(R.id.rbt_on);
        off=(RadioButton)findViewById(R.id.rbt_off);
        lod=(RadioButton)findViewById(R.id.rbt_lod);
        id = getIntent().getIntExtra("id", -1);
        com = ListActivity.t.getOneStudent(id);
        et1.setText(com.商品名稱);
        et2.setText(com.商品類型);
        et3.setText(com.商品售價);
        et4.setText(com.商品特價);
        et5.setText(com.商品數量);
        on.setOnCheckedChangeListener(mOnCheckedChangeListener);
        off.setOnCheckedChangeListener(mOnCheckedChangeListener);
        lod.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbt_on:
                    comNow = on.getText().toString();
                    break;
                case R.id.rbt_off:
                    comNow = off.getText().toString();
                    break;
                case R.id.rbt_lod:
                    comNow = lod.getText().toString();
                    break;
            }
        }
    };

    public void Update(View v){
        com.商品名稱 = et1.getText().toString();
        com.商品類型 = et2.getText().toString();
        com.商品售價 = et3.getText().toString();
        com.商品特價 = et4.getText().toString();
        com.商品數量 = et5.getText().toString();
        ListActivity.t.update(com);
        finish();
    }

    public void rstart(View v){
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
    }

    public void back(View v){
        finish();
    }
}
