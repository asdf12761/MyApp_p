package com.example.acer.myapp_p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onView(View v) {
        Intent it = new Intent(MainActivity.this, selectActivity.class);
        startActivity(it);
    }

    public void about(View v) {
        Toast.makeText(MainActivity.this,"這是我的第一個作品，尚有許多未完成及需要改進的空間，未來也會陸續新增和修正，請多指教！",Toast.LENGTH_LONG).show();

    }
}
