package com.example.acer.myapp_p;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.acer.myapp_p.data.comList;

import java.io.FileNotFoundException;

public class AddActivity extends AppCompatActivity {
    String comNow = "";
    String image = "";
    private RadioButton on,off,lod;
    EditText name,type,price,sprice,type2;
    ImageView img;
    TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        on=(RadioButton)findViewById(R.id.rbt_on);
        off=(RadioButton)findViewById(R.id.rbt_off);
        lod=(RadioButton)findViewById(R.id.rbt_lod);
        name=(EditText)findViewById(R.id.et_name);
        type=(EditText)findViewById(R.id.et_type);
        price=(EditText)findViewById(R.id.et_price);
        sprice=(EditText)findViewById(R.id.et_sprice);
        type2=(EditText)findViewById(R.id.et_type2);
        tw=(TextView) findViewById(R.id.textView7);
        //取得圖片控制項ImageView
        ImageView img = (ImageView) findViewById(R.id.imageButton);
        on.setOnCheckedChangeListener(mOnCheckedChangeListener);
        off.setOnCheckedChangeListener(mOnCheckedChangeListener);
        lod.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbt_on:
                    if(on.isChecked()){
                        comNow = on.getText().toString();
                    }else{
                    }
                    break;
                case R.id.rbt_off:
                    if(off.isChecked()){
                        comNow = off.getText().toString();
                    }else{
                    }
                    break;
                case R.id.rbt_lod:
                    if(lod.isChecked()){
                        comNow = lod.getText().toString();
                    }else{
                    }
                    break;
            }
            tw.setText(comNow);
        }
    };

    public void select(View v){
        Intent intent = new Intent();
        //開啟Pictures畫面Type設定為image
        intent.setType("image/*");
        //使用Intent.ACTION_GET_CONTENT這個Action                                            //會開啟選取圖檔視窗讓您選取手機內圖檔
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //取得相片後返回本畫面
        startActivityForResult(intent, 1);
//        for (int i = 0; i < 50; i++) {
//            //ImageViewのIDを文字列から取得する
//            int viewId = getResources().getIdentifier("iv" + (i + 1), "id", getPackageName());
//            ImageView iv = (ImageView)findViewById(viewId);
//            //文字列から画像のdrawableのIDを取得する
//            int imageId = getResources().getIdentifier("image" + (i + 1), "drawable", getPackageName());
//            //画像をImageViewにセットする
//            iv.setImageResource(imageId);
//        }
    }



    public void pass(View v){
        EditText ed1 = (EditText) findViewById(R.id.et_name);
        EditText ed2 = (EditText) findViewById(R.id.et_type);
        EditText ed3 = (EditText) findViewById(R.id.et_price);
        EditText ed4 = (EditText) findViewById(R.id.et_sprice);
        EditText ed5 = (EditText) findViewById(R.id.et_type2);

        ListActivity.t.add(new comList(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(),ed4.getText().toString(),
                ed5.getText().toString(),comNow,image));
        finish();
    }

    public void rstart(View v){
        name.setText("");
        type.setText("");
        price.setText("");
        sprice.setText("");
        type2.setText("");

    }

    public void back(View v){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //當使用者按下確定後
        if (resultCode == RESULT_OK) {
            //取得圖檔的路徑位置
            Uri uri = data.getData();
            //寫log
            Log.e("uri", uri.toString());
            //抽象資料的接口
            ContentResolver cr = this.getContentResolver();
            try {
                //由抽象資料接口轉換圖檔路徑為Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                // 將Bitmap設定到ImageView
                img.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    }

