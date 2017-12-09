package com.example.acer.myapp_p;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.toselect);
        button3=(Button)findViewById(R.id.toabout);

    }

    public void onView(View v) {
        Intent it = new Intent(MainActivity.this, selectActivity.class);
        startActivity(it);
    }

    public void about(View v) {

    }
}
