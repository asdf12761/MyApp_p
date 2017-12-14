package com.example.acer.myapp_p;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddActivity extends AppCompatActivity {
    private RadioButton on,off,lod;
    EditText name,type,price,sprice,type2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        on=(RadioButton)findViewById(R.id.rbt_on);
        off=(RadioButton)findViewById(R.id.rbt_off);
        lod=(RadioButton)findViewById(R.id.rbt_lod);
        name=(EditText)findViewById(R.id.et_name);
        type=(EditText)findViewById(R.id.et_type);
        price=(EditText)findViewById(R.id.et_price);
        sprice=(EditText)findViewById(R.id.et_sprice);
        type2=(EditText)findViewById(R.id.et_type2);
    }



}
