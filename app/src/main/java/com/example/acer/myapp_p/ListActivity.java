package com.example.acer.myapp_p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.acer.myapp_p.data.DAOType;
import com.example.acer.myapp_p.data.OnCloudReceivedListener;
import com.example.acer.myapp_p.data.comListDAO;
import com.example.acer.myapp_p.data.comLostDAOFactory;

public class ListActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener
        , OnCloudReceivedListener {
    public static comListDAO t;
    final DAOType type = DAOType.CLOUD;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    GestureDetector mGD;
    final String TAG = "CloudImpl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        t = comLostDAOFactory.getStudentDAO(type, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(ListActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mGD = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        }
        );
        mRecyclerView.addOnItemTouchListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume, before set Adapter");
        mAdapter = new MyAdapter(ListActivity.this, t.getData());
        mRecyclerView.setAdapter(mAdapter);
        Log.d(TAG, "onResume, after set Adapter");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(ListActivity.this, AddActivity.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(), e.getY());
        Log.d("Touch", "onInterceptTouchEvent");
        if (mGD.onTouchEvent(e))
        {
            Log.d("Touch", "Single Tap up");
            int position = rv.getChildLayoutPosition(v);
            // Toast.makeText(MainActivity.this, "posi:" + position, Toast.LENGTH_SHORT).show();
            if (position >= 0)
            {
                Intent it = new Intent(ListActivity.this, ItenActivity.class);
                it.putExtra("id", t.getData()[position].id);
                startActivity(it);
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void onReceivedEvent() {
        mAdapter = new MyAdapter(ListActivity.this, t.getData());
        mRecyclerView.setAdapter(mAdapter);
    }
}


//    private void setAdapter() {
//        db = new MyDB_com(this).open();
//        fillData();
//    }
//
//    void fillData() {
//        Cursor c = db.getALL();
//        startManagingCursor(c);
//        SimpleCursorAdapter scAdapter = new SimpleCursorAdapter(
//                this,
//                R.layout.item_list_com, c,
//                new String[]{"商品名稱", "商品數量"},
//                new int[]{R.id.title, R.id.artist},
//                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//        lv.setAdapter(scAdapter);
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        rowId = id;
//        System.out.println("rowId = " + rowId);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // TODO Auto-generated method stub
//        menu.add(0, MENU_INSERT, 0, "新增商品資料")
//                .setIcon(android.R.drawable.ic_menu_add)
//                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        menu.add(0, MENU_DELETE, 0, "刪除商品資料")
//                .setIcon(android.R.drawable.ic_menu_delete)
//                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        menu.add(0, MENU_UPDATE, 0, "修改商品資料")
//                .setIcon(android.R.drawable.ic_menu_edit)
//                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case MENU_INSERT:
//                intent.setClass(ListActivity.this, AddActivity.class);
//                intent.putExtra("test", "進入商品建立頁面");
//                startActivity(intent);
//                break;
//            case MENU_DELETE:
//                AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this);
//                dialog.setMessage(R.string.delele_confirm);
//                dialog.setNeutralButton(R.string.okay, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        db.delete(rowId);
//                        fillData();
//                    }
//                });
//                dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface arg0, int arg1) {
//                    }
//                });
//                dialog.show();
//                break;
//            case MENU_UPDATE:
//                intent.setClass(ListActivity.this, EditActivity.class);
//                intent.putExtra("test", "進入商品修改頁面");
//                startActivity(intent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }