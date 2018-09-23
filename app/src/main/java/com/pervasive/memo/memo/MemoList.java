package com.pervasive.memo.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shubh on 9/23/2018.
 */

public class MemoList extends AppCompatActivity {
    TextView name, email, phNo;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_list);
        name = (TextView) findViewById(R.id.memo_name);
        phNo = (TextView) findViewById(R.id.memo_phNo);
        email = (TextView) findViewById(R.id.memo_email);
        add = (Button)findViewById(R.id.add);

    }
    @Override
    protected void onStart() {

        super.onStart();
        name.setText(getIntent().getStringExtra("Name"));
        email.setText(getIntent().getStringExtra("Phone_Number"));
        phNo.setText(getIntent().getStringExtra("Email"));
        final List<String> str= new ArrayList<String>();
        str.add("some");
        str.add("some");
        str.add("some");
        str.add("some");
        final ArrayAdapter adapter = new ArrayAdapter<String>(MemoList.this,R.layout.list_item,str);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Toast.makeText(MemoList.this,getIntent().getStringExtra("Name") , Toast.LENGTH_SHORT).show();
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                str.add("som1");
                adapter.notifyDataSetChanged();
            }
        });

    }
}
