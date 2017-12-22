package com.example.acer.myapp_p;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


public class selectActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

    }
    public void sarch(View v){
        Intent it = new Intent(selectActivity.this,ListSetActivity.class);
        startActivity(it);

    }

    public void onBack(View v) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        searchView.setSubmitButtonEnabled(true);
        return true;
    }

    class SearchResultsActivity extends selectActivity {
        TextView tv;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_select);

            tv = (TextView) findViewById(R.id.txt1);

            handleIntent(getIntent());
        }


        @Override
        protected void onNewIntent(Intent intent)
        {
            handleIntent(intent);
        }


        private void handleIntent(Intent intent)
        {
            if (Intent.ACTION_SEARCH.equals(intent.getAction()))
            {
                String query = intent.getStringExtra(SearchManager.QUERY);
                tv.setText("搜尋的結果為"+query.toString());
            }
        }

    }

}


//    public void edit(View v){
//        final View item = LayoutInflater.from(selectActivity.this).inflate(R.layout.item_edit_layout, null);
//        new AlertDialog.Builder(selectActivity.this)
//                .setTitle(R.string.input_ur_name)
//                .setView(item)
//                .setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        EditText editText = (EditText) item.findViewById(R.id.editText);
//                        String name = editText.getText().toString();
//                        if (TextUtils.isEmpty(name)) {
//                            Toast.makeText(getApplicationContext(), R.string.input_ur_name, Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getApplicationContext(), getString(R.string.hi) + name, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                })
//                .setPositiveButton(R.string.cancal, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                })
//                .show();
//    }

