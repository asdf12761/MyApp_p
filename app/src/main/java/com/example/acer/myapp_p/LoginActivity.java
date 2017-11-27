package com.example.acer.myapp_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    TextView tv1,tv2;
    EditText et1,et2;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv1=(TextView)findViewById(R.id.tv_id);
        tv2=(TextView)findViewById(R.id.tv_pw);
        et1=(EditText)findViewById(R.id.et_id);
        et2=(EditText)findViewById(R.id.et_pw);
        btn1=(Button)findViewById(R.id.btn_Submit);
        btn2=(Button)findViewById(R.id.btn_back);
    }

}
