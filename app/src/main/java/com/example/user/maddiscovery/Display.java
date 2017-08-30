package com.example.user.maddiscovery;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView viewinfo;
        DBHelper dbHelper;
        SQLiteDatabase db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

    try{
        db=openOrCreateDatabase("event.db",1,null);

        Cursor c =db.rawQuery("SELECT * FROM EVENT",null);
        TextView v =(TextView)findViewById(R.id.txtview);
        c.moveToFirst();
        String temp="";
        while (!c.isAfterLast()) {

            String s1 = c.getString(1);
            String s2 = c.getString(2);
            String s3 = c.getString(3);
            String s4 = c.getString(4);
            String s5 = c.getString(5);

            temp = temp + "\nName: " + s1 + "\nEmail:" + s2 + "\nLocation:" + s3 + "\nPhone:"
                    + s4 + "\nLocation:" + s5;
            c.moveToNext();
        }
            v.setText(temp);

        }

        catch (SQLiteException e)

        {

        }


    }

    }