package com.example.acer.myapp_p;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class selectActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

    }
    public void sarch(View v){
        Intent it = new Intent(selectActivity.this,ListSetActivity.class);
        startActivity(it);

    }
    public void edit(View v){
        final View item = LayoutInflater.from(selectActivity.this).inflate(R.layout.item_edit_layout, null);
        new AlertDialog.Builder(selectActivity.this)
                .setTitle(R.string.input_ur_name)
                .setView(item)
                .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = (EditText) item.findViewById(R.id.editText);
                        String name = editText.getText().toString();
                        if (TextUtils.isEmpty(name)) {
                            Toast.makeText(getApplicationContext(), R.string.input_ur_name, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.hi) + name, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setPositiveButton(R.string.cancal, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    public void Send(View v){

    }

    public void onBack(View v) {
        finish();
    }
}
