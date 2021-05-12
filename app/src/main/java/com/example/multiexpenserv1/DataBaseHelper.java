package com.example.multiexpenserv1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String EXPENSES_TABLE_NAME = "EXPENSES";
    public static final String TITLE = "TITLE";
    public static final String AMOUNT = "AMOUNT";
    public static final String DAY = "DAY";
    public static final String MONTH = "MONTH";
    public static final String YEAR = "YEAR";
    public static final String CATEGORY = "CATEGORY";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String DATABASE_NAME = "multiexpenserdb";
    public static final String BALANCE_TABLE_NAME = "BALANCE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Creating Expenses table structure
        String CreateTableExpenseStatement= "CREATE TABLE " + EXPENSES_TABLE_NAME + "(INT ID PRIMARY KEY AUTOINCREMENT, TEXT " + TITLE + ",TEXT " + AMOUNT + ",TEXT " + DAY + ",TEXT " + MONTH + ",TEXT " + YEAR + ",TEXT " + CATEGORY + ",TEXT " + DESCRIPTION + " )";
        //For executing the sql statement
        db.execSQL(CreateTableExpenseStatement);

        //Creating  Balance table structure;
        String CreateTableBalanceStatement= "CREATE TABLE " + BALANCE_TABLE_NAME + " (INT ID PRIMARY KEY AUTOINCREMENT ,TEXT " +AMOUNT+" ,TEXT " + DAY + ",TEXT " + MONTH + ",TEXT " + YEAR +", TEXT" + DESCRIPTION + " )";
        //For executing the sql statement
        db.execSQL(CreateTableBalanceStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // Write funtion for expenses
    public boolean addExpenseToDB(expense obj){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        // Putting content values with corresponding to the column names
        cv.put(TITLE,obj.getTitle());
        cv.put(AMOUNT,obj.getAmount());
        cv.put(DAY,obj.getDay());
        cv.put(MONTH,obj.getMonth());
        cv.put(YEAR,obj.getYear());
        cv.put(CATEGORY,obj.getCategory());
        cv.put(DESCRIPTION,obj.getDescription());

        //Inserting values into the table
        long insert=db.insert(EXPENSES_TABLE_NAME,null,cv);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }


    // Write funtion for Balance
    public boolean addBalanceDetailsToDB(balance obj){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        // Putting content values with corresponding to the column names
        cv.put(AMOUNT,obj.getAmount());
        cv.put(DAY,obj.getDay());
        cv.put(MONTH,obj.getMonth());
        cv.put(YEAR,obj.getYear());
        cv.put(DESCRIPTION,obj.getDescription());

        //Inserting values into the table
        long insert=db.insert(BALANCE_TABLE_NAME,null,cv);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }


    // To get the data from the Expenses
    public  List<expense> getAllExpenses() {
        //Declaring list to return
        List<expense> returnList = new ArrayList<>();
        //Query to get data
        String query = "SELECT * FROM " + EXPENSES_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        //Check if the cursor has successfully fetched the results
        if (cursor.moveToFirst()) {
//            // loop through the cursor and create a new class objects. put them into the return list
            do {
//                taking data from columns
                int ID = cursor.getInt(0);
                String Title = cursor.getString(1);
                String Amount = cursor.getString(2);
                String Day = cursor.getString(3);
                String Month = cursor.getString(4);
                String Year = cursor.getString(5);
                String Category = cursor.getString(6);
                String Description = cursor.getString(7);
//                 create object using constructor
                expense obj = new expense(ID, Title, Amount, Day, Month, Year, Category, Description);
                returnList.add(obj);
            } while (cursor.moveToNext());
        } else {
            expense obj = new expense(-1, "No title", "-1-1-1", "-1", "-1", "-1", "-1", "Some error occured");
            returnList.add(obj);
        }
        cursor.close();
        db.close();
        return returnList;
    }

    // To get the data from the Balance
    public  List<balance> getAllBalance() {
        //Declaring list to return
        List<balance> returnList = new ArrayList<>();
        //Query to get data
        String query = "SELECT * FROM " + BALANCE_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        //Check if the cursor has successfully fetched the results
        if (cursor.moveToFirst()) {
//            // loop through the cursor and create a new class objects. put them into the return list
            do {
//                taking data from columns
                int ID = cursor.getInt(0);
                String Amount = cursor.getString(1);
                String Day = cursor.getString(2);
                String Month = cursor.getString(3);
                String Year = cursor.getString(4);
                String Description = cursor.getString(5);
//                 create object using constructor
                balance obj = new balance(ID, Amount, Day, Month, Year,  Description);
                returnList.add(obj);
            } while (cursor.moveToNext());
        } else {
            balance obj = new balance(-1,"-111","-1","-1","-1","Some error occured");
            returnList.add(obj);
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
