package com.example.acer.myapp_p;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private MyDB_com db;
    Intent intent = new Intent();
    ListView lv;
    private long rowId;
    private EditText editText1, et1;
    private String editString1, editString2;
    protected static final int MENU_INSERT = Menu.FIRST;
    protected static final int MENU_DELETE = Menu.FIRST + 1;
    protected static final int MENU_UPDATE = Menu.FIRST + 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(this);
        setAdapter();
    }

    private void setAdapter() {
        db = new MyDB_com(this).open();
        fillData();
    }

    void fillData() {
        Cursor c = db.getALL();
        startManagingCursor(c);
        SimpleCursorAdapter scAdapter = new SimpleCursorAdapter(
                this,
                R.layout.item_list_com, c,
                new String[]{"商品名稱", "商品類型"},
                new int[]{R.id.title, R.id.artist},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(scAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        rowId = id;
        System.out.println("rowId = " + rowId);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(0, MENU_INSERT, 0, "新增商品資料")
                .setIcon(android.R.drawable.ic_menu_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_DELETE, 0, "刪除商品資料")
                .setIcon(android.R.drawable.ic_menu_delete)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_UPDATE, 0, "修改商品資料")
                .setIcon(android.R.drawable.ic_menu_edit)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_INSERT:
                intent.setClass(ListActivity.this, AddActivity.class);
                intent.putExtra("test", "進入商品新增頁面");
                startActivity(intent);
                break;
            case MENU_DELETE:
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this);
                dialog.setMessage(R.string.delele_confirm);
                dialog.setNeutralButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        db.delete(rowId);
                        fillData();
                    }
                });
                dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                dialog.show();
                break;
            case MENU_UPDATE:
                intent.setClass(ListActivity.this, EditActivity.class);
                intent.putExtra("test", "進入商品修改頁面");
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


