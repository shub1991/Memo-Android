package com.pervasive.memo.memo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, phNo;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        phNo = (EditText) findViewById(R.id.phNo);
        email = (EditText) findViewById(R.id.email);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MemoList.class);
                intent.putExtra("Name", name.getText().toString());
                intent.putExtra("Phone_Number", phNo.getText().toString());
                intent.putExtra("Email", email.getText().toString());
                startActivity(intent);
            }
        });
    }
}
