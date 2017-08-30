package com.example.user.maddiscovery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "event.db";
    public static final int DATABASE_VERSION = 1;
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";
    public static final String MOBILE = "phone";
    public static final String LOCATION = "location";
    public static final String PASSWORD = "pass";
    public static final String ID = "id";
    public static final String TABLE_NAME = "EVENT";

    SQLiteDatabase db;

    public static final String CREATE_TABLE = "CREATE TABLE EVENT " +
            "( id PRIMARY KEY, username TEXT,email TEXT, phone TEXT ,location TEXT,pass TEXT);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;
    }
    public String searchpassword(String unmame){
        db = this.getReadableDatabase();
        String query = "SELECT username,pass FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String un, pss;
        pss = "Record not found";
        if (cursor.moveToFirst()){
            do {
                un = cursor.getString(0);
                if (un.equals(unmame)){
                    pss = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return pss;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + CREATE_TABLE;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void insert_event (Contact c){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String query ="SELECT *FROM EVENT";
        Cursor cursor = db.rawQuery(query,null);
        int count =cursor.getCount();


        contentValues.put(ID,count);
        contentValues.put(USERNAME,c.uname);
        contentValues.put(EMAIL,c.mail);
        contentValues.put(LOCATION,c.location);
        contentValues.put(MOBILE,c.mobilephone);
        contentValues.put(PASSWORD,c.password);
      db.insert(TABLE_NAME,null,contentValues);

    }
    public void delete_event (String uname){
        this.getWritableDatabase().delete("EVENT","USERNAME =' "+uname+"'",null);

    }
    public void update_event(String old_uname,String new_uname){
        this.getWritableDatabase().execSQL("UPDATE PERSON SET USERNAME='"+new_uname+"'WHERE USERNAME='"+old_uname+"'");
    }

}