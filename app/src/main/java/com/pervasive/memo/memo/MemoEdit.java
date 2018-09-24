package com.pervasive.memo.memo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.pervasive.memo.memo.FeedReaderContract.FeedEntry;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shubh on 9/23/2018.
 */

public class MemoEdit extends AppCompatActivity {
    FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);
    Button save;

    EditText tittle;
    EditText desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_list_edit);
        tittle=(EditText) findViewById(R.id.title);
        desc=(EditText) findViewById(R.id.desc);
        save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();

                values.put(FeedEntry.COLUMN_NAME_TITLE, tittle.getText().toString());
                values.put(FeedEntry.COLUMN_NAME_SUBTITLE,desc.getText().toString());

                long newRowId = 0;
                try {
                    newRowId = db.insertOrThrow(FeedEntry.TABLE_NAME, null, values);
                }catch (Exception ex){
                    Toast.makeText(MemoEdit.this, ex.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MemoEdit.this, "Item Added",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
