package com.example.acer.myapp_p;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
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
        on.setOnCheckedChangeListener(mOnCheckedChangeListener);
        off.setOnCheckedChangeListener(mOnCheckedChangeListener);
        lod.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbt_on:
                    break;
                case R.id.rbt_off:
                    break;
                case R.id.rbt_lod:
                    break;
            }
        }
    };

    public void pass(View v){

    }

    public void rstart(View v){
        name.setText("");
        type.setText("");
        price.setText("");
        sprice.setText("");
        type2.setText("");

    }

    public void back(View v){
        finish();
    }
}
