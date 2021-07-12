package com.example.projectuas.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    //Mendeklarasikan variabel-variabel database
    public static final String database_name = "db_login";
    public static final String table_name = "table_login";

    public static final String rov_id = "_id";
    public static final String rov_email = "Email";
    public static final String rov_password = "Password";

    private SQLiteDatabase db;



    //mendefenisi nilai context dengan nama database, factory dan version pada method DBHelper
    public DBHelper(Context context) {
        super(context, database_name, null, 2);
        db = getWritableDatabase();
    }


    //Memberikan nilai variabel pada database db dengan membuat method oncreat
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table_name + "(" + rov_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + rov_email + " TEXT, " + rov_password + " TEXT) ";
        db.execSQL(query);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
    }

    //Insert Data
    public void insertData(ContentValues values){
        db.insert(table_name, null, values);
    }


    //Check email dan password
    public boolean checkUser(String email, String password){
        String[] columns = {rov_id};
        SQLiteDatabase db = getReadableDatabase();
        String selection = rov_email + "=?" + " and " + rov_password + "=?";
        String[] selectionArgs = {email,password};
        Cursor cursor = db.query(table_name, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return false;
    }
}
