package com.example.user.maddiscovery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 8/2/2016.
 */
public class Event_con {

    private DBHelper dbHelper;


    public Event_con(Context context) {

        dbHelper = new DBHelper(context);

    }



    public int insert(Event event) {

        //Open connection to write data

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Event.KEY_email, event.email);

        values.put(Event.KEY_location,event.location);

        values.put(Event.KEY_name, event.name);



        // Inserting Row

        long event_Id = db.insert(Event.TABLE, null, values);

        db.close(); // Closing database connection

        return (int) event_Id;
    }



    public void delete(int event_Id) {



        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // It's a good practice to use parameter ?, instead of concatenate string

        db.delete(Event.TABLE, Event.KEY_ID + "= ?", new String[] { String.valueOf(event_Id) });

        db.close(); // Closing database connection

    }



    public void update(Event event) {



        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();



        values.put(Event.KEY_name,event.name);

        values.put(Event.KEY_email,event.email);

        values.put(Event.KEY_name, event.name);



        // It's a good practice to use parameter ?, instead of concatenate string

        db.update(Event.TABLE, values, Event.KEY_ID + "= ?", new String[] { String.valueOf(event.event_ID) });

        db.close(); // Closing database connection

    }



    public ArrayList<HashMap<String, String>>  getEventList() {

        //Open connection to read only

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT  " +

                Event.KEY_ID + "," +

                Event.KEY_name + "," +

                Event.KEY_email + "," +

                Event.KEY_location +

                " FROM " + Event.TABLE;



        //Event event = new Event();

        ArrayList<HashMap<String, String>> eventList = new ArrayList<HashMap<String, String>>();



        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list



        if (cursor.moveToFirst()) {

            do {

                HashMap<String, String> event = new HashMap<String, String>();

                event.put("id", cursor.getString(cursor.getColumnIndex(Event.KEY_ID)));

                event.put("name", cursor.getString(cursor.getColumnIndex(Event.KEY_name)));

                eventList.add(event);



            } while (cursor.moveToNext());

        }

        cursor.close();

        db.close();

        return eventList;

    }


    public Event getEventById(int Id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery =  "SELECT  " +

                Event.KEY_ID + "," +

                Event.KEY_name + "," +

                Event.KEY_email + "," +

                Event.KEY_location +

                " FROM " + Event.TABLE

                + " WHERE " +

                Event.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string



        int iCount =0;

        Event event = new Event();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {

            do {

                event.event_ID =cursor.getInt(cursor.getColumnIndex(Event.KEY_ID));

                event.name =cursor.getString(cursor.getColumnIndex(Event.KEY_name));

                event.email  =cursor.getString(cursor.getColumnIndex(Event.KEY_email));

                event.location =cursor.getString(cursor.getColumnIndex(Event.KEY_location));

            } while (cursor.moveToNext());

        }

        cursor.close();

        db.close();

        return event;

    }



}