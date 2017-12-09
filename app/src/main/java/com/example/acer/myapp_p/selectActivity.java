package com.example.acer.myapp_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        btn1=(Button)findViewById(R.id.btn_sarch);
        btn2=(Button)findViewById(R.id.btn_edit);
        btn3=(Button)findViewById(R.id.btn_action);
    }

    public void onBack(View v) {
        finish();
    }
}
