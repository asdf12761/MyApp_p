package com.example.acer.myapp_p;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class ListSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_set);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menu.add 參數定義:
        //menu.add (group ID , item_ID, 排列順序, item秀在畫面的名稱);
        menu.add(0, 1, 1, "新增清單");
        menu.add(0, 2, 2, "修改清單");
        menu.add(1, 3, 3, "刪除清單");
        menu.add(1, 4, 4, "返回選單");
        super.onCreateOptionsMenu(menu);
        return true;
    }
}
