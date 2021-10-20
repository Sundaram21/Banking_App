package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(5751,'Ayush', 'ayush@gmail.com','8570','9876546789', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6596,'Kewal', 'kewal@gmail.com','8747','9953458678', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8560,'Anurag', 'anurag@gmail.com','7568','9655457684', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(5587,'Sahil', 'sahil@gmail.com','7459','8130674357', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6870,'Mohak', 'mohak@gmail.com','3009','7859184532', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6432,'Karan', 'karan@gmail.com','7785','8287178567', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6636,'Akshat', 'akshat@gmail.com','7589','8470956453', 7850)");
        db.execSQL("insert into " + TABLE_NAME + " values(6796,'Priyam', 'priyam@gmail.com','7776','9555828976', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8439,'Bhuvesh', 'bhuvesh@gmail.com','8266','9899565548', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4534,'Kunal', 'kunal@gmail.com','8255','9789591201', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(5843,'Pavas', 'pavas@gmail.com','7689','8915641276', 8500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9877,'David', 'david@gmail.com','7984','965083229', 12000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3768,'Teja', 'teja@gmail.com','8632','8800305675', 3750)");
        db.execSQL("insert into " + TABLE_NAME + " values(8768,'Archit', 'Archit@gmail.com','7362','9576873254', 4700)");
        db.execSQL("insert into " + TABLE_NAME + " values(7466,'Alok', 'alok@gmail.com','8167','9375643326', 5600)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}