package com.gzeinnumer.listviewsearchfunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //todo 3
    private ListView listSearch;
    private EditText editSearch;
    private ArrayAdapter<String> adapter;

    String data[]={
            "M. Fadli Zein","Ririn Darmayanti Zein","Rendi Yulianto Zein"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 4
        listSearch = findViewById(R.id.list);
        editSearch = findViewById(R.id.edit);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.text, data);
        listSearch.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //todo 5
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
