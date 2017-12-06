package com.example.acer.myapp_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btn1=(Button)findViewById(R.id.btn_search);
        btn2=(Button)findViewById(R.id.btn_his);
        btn3=(Button)findViewById(R.id.btn_do);
        btn4=(Button)findViewById(R.id.btn_re);
    }

    public void onBack(View v) {
        finish();
    }
}
