package com.example.acer.myapp_p;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.id;

public class ListSetActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GestureDetectorCompat gestureDetector;
    Intent intent = new Intent();
    private long rowId;
    private MyDB_List db ;
    private Cursor cursor;
    ListView lv;
    EditText et;
    private EditText editText1,et1;
    private String editString1,editString2;

    private int mNoteNumber = 1;
    protected static final int MENU_INSERT = Menu.FIRST;
    protected static final int MENU_DELETE = Menu.FIRST + 1;
    protected static final int MENU_UPDATE = Menu.FIRST + 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_set);
        gestureDetector = new GestureDetectorCompat(this, new MyGestureListener());
        lv = (ListView)findViewById(R.id.listView);
        lv.setOnItemClickListener(this);
        lv.setOnTouchListener(onTouchView);
        setAdapter();
    }

    private void setAdapter() {
        db = (MyDB_List) new MyDB_List(this).open();
        fillData();
    }

    void fillData() {
        Cursor c = db.getAll();
        startManagingCursor(c);
        SimpleCursorAdapter scAdapter = new SimpleCursorAdapter(
                this,
                R.layout.alertdialog_edittext,
                c,
                new String[]{"name"},
                new int[]{R.id.tv_names},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(scAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        rowId = id;
        System.out.println("rowId = " + rowId);
        Toast.makeText(this,"選擇了第" + rowId + "個清單",Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(0, MENU_INSERT, 0, "新增清單")
                .setIcon(android.R.drawable.ic_menu_add)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_DELETE, 0, "刪除清單")
                .setIcon(android.R.drawable.ic_menu_delete)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_UPDATE, 0, "修改清單")
                .setIcon(android.R.drawable.ic_menu_edit)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_INSERT:
                et1 = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("製作清單")
                        .setMessage("請輸入製作的清單名稱")
                        .setView(et1)
                        .setNeutralButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editString2 = et1.getText().toString();
                                if (db.create(editString2) > 0) {
                                        cursor = db.getAll();
                                        fillData();
                                    Toast.makeText(ListSetActivity.this,"建立成功:" + editString2,Toast.LENGTH_SHORT).show();
                                    }
                            }
                        })
                        .show();
                builder.setPositiveButton("取消", null);
                break;
            case MENU_DELETE:
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListSetActivity.this);
                dialog.setMessage(R.string.delele_confirm);
                dialog.setNeutralButton(R.string.okay,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        db.delete(rowId);
                        fillData();
                    }
                });
                dialog.setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                dialog.show();
                break;
            case MENU_UPDATE:
                editText1 = new EditText(this);
                builder = new AlertDialog.Builder(this);
                builder.setTitle("修改項目名稱")
                        .setMessage("請輸入您想修改的項目名稱")
                        .setView(editText1)
                        .setNeutralButton("確認", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editString1 = editText1.getText().toString();
                                if (!editString1.equals("")) {
                                    db.update(rowId, editText1.getText().toString());
                                    fillData();
                                }
                            }
                        })
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private View.OnTouchListener onTouchView = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.d(">>>", "onTouch");
            return gestureDetector.onTouchEvent(event);
        }
    };

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(">>>", "onDoubleTap");
            rowId = id;
            System.out.println("rowId = " + rowId);
//            AlertDialog.Builder builder = new AlertDialog.Builder(ListSetActivity.this);
//            builder.setTitle("清單選項");
//            builder.setMessage("選擇確認進入商品編輯頁面，取消後若保持選擇狀態能進行修改、刪除清單");
//            builder.setNeutralButton("確認", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
                    intent.setClass(ListSetActivity.this, ListActivity.class);
                    intent.putExtra("test", "進入商品頁面");
                    startActivity(intent);
            Toast.makeText(ListSetActivity.this,"進入商品頁面",Toast.LENGTH_SHORT).show();
//                }
//            });
//            builder.setPositiveButton("取消", null);
//            builder.show();
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }


}
