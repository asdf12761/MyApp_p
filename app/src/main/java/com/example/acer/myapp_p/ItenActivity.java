package com.example.acer.myapp_p;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.acer.myapp_p.data.comList;

public class ItenActivity extends AppCompatActivity {

    protected static final int MENU_UPDATE = Menu.FIRST;
    protected static final int MENU_DELETE = Menu.FIRST + 1;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    comList stu;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iten);
        tv1 =(TextView) findViewById(R.id.tv_name_i);
        tv2 =(TextView) findViewById(R.id.tv_type_i);
        tv3 =(TextView) findViewById(R.id.tv_price_i);
        tv4 =(TextView) findViewById(R.id.tv_sprice_i);
        tv5 =(TextView) findViewById(R.id.tv_rtype2_i);
        tv6 = (TextView) findViewById(R.id.tv_id);
        tv7 =(TextView) findViewById(R.id.tv_comNow_i);
        id = getIntent().getIntExtra("id", -1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        stu = ListActivity.t.getOneStudent(id);
        tv6.setText(String.valueOf(stu.id)+"號商品:");
        tv1.setText(stu.商品名稱);
        tv2.setText(stu.商品類型);
        tv3.setText(stu.商品售價);
        tv4.setText(stu.商品特價);
        tv5.setText(stu.商品數量);
        tv7.setText(stu.comNow);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_UPDATE, 0, "修改清單")
                .setIcon(android.R.drawable.ic_menu_edit)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_DELETE, 0, "刪除清單")
                .setIcon(android.R.drawable.ic_menu_delete)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_UPDATE:
                Intent it = new Intent(ItenActivity.this, EditActivity.class);
                it.putExtra("id", id);
                startActivity(it);
                break;
            case MENU_DELETE:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.delele_confirm);
                builder.setNeutralButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListActivity.t.delete(stu);
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
