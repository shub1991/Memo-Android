package com.pervasive.memo.memo;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shubh on 9/23/2018.
 */

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> maintitle;
    private final ArrayList<String> subtitle;
    private final ArrayList<Integer> ids;
    FeedReaderDbHelper mDbHelper;
    SQLiteDatabase db;

    public MyListAdapter(Activity context, ArrayList<String> maintitle, ArrayList<String> subtitle, ArrayList<Integer> ids) {
        super(context, R.layout.list_item, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.ids=ids;
        mDbHelper =  new FeedReaderDbHelper(context);

        db = mDbHelper.getWritableDatabase();
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        final TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        Button deleteBtn = (Button) rowView.findViewById(R.id.deleteBtn);
        titleText.setText(maintitle.get(position));
        subtitleText.setText(subtitle.get(position));

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Deleted refresh the page",Toast.LENGTH_LONG).show();
                db.delete("Memos","_id" + "=" + ids.get(position), null);
                context.recreate();
            }
        });
        return rowView;

    };
}
