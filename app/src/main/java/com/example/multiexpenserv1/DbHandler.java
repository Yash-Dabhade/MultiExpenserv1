package com.example.multiexpenserv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;

public class  DbHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "multiexpenser_db";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String MONTHLY_INCOME = "monthly_income";
    public static final String CURRENT_BALANCE = "currrent_balance";
    public static final String EXTRA_INCOME = "extra_income";
    public static final int VERSION = 1;

    private HashMap hp;

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("create table user_table " + "(first_name text,last_name text,email text,monthly_income text, current_balance text, extra_income text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS user_table");
        onCreate(db);
    }

    public boolean insertUser(String fname, String lname, String email, String montly_income, String current_balance, String extra_income) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_name", fname);
        contentValues.put("last_name", lname);
        contentValues.put("email", email);
        contentValues.put("monthly_income", montly_income);
        contentValues.put("current_balance", current_balance);
        contentValues.put("extra_income", extra_income);
        db.insert("user_table", null, contentValues);
        return true;
    }
}
//    public String getCurrentBalanceDB() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<String> array_list = new ArrayList<String>();
//        Cursor res = db.rawQuery("select  * from user_table", null);
//        res.moveToFirst();
//        while (res.isAfterLast() == false) {
//            array_list.add(res.getString(res.getColumnIndex(CURRENT_BALANCE)));
//            res.moveToNext();
//        }
//        return array_list.get(0);
//    }
//    public String getFirstNameDB() {
//        ArrayList<String> array_list = new ArrayList<String>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res = db.rawQuery("select  * from user_table", null);
//        res.moveToFirst();
//        while (res.isAfterLast() == false) {
//            array_list.add(res.getString(res.getColumnIndex(FIRST_NAME)));
//            res.moveToNext();
//        }
//        return array_list.get(0);
//    }
//}