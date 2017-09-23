/*
 * %W% %E% Zain-Ul-Abedin
 *
 * Copyright (c) 2017-2018. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of ZainMustafaaa.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * for learning purposes.
 *
 */
package notes.save.com.notepad.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zainm on 21-Sep-17.
 */

public class NotesDatabase extends SQLiteOpenHelper {

    /** declaring and initializing database attributes*/
    final static String DATABASE_NAME = "notes.db";
    final static String TABLE_NAME = "data";
    final static String COL_1 = "notepad";
    final static String COL_2 = "time";

    /**
     * class constructor
     * @param context
     * */
    public NotesDatabase(Context context) {
        /**
         * passing context, database name and version to super class to initialize database
         * @param context
         * @param DATABASE_NAME
         * @param null for cursor factory
         * @param 1
         * */
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * override method onCreate
     * @param sqLiteDatabase
     * */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /** traditional database query for create table */
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "( ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_1 + " TEXT, " + COL_2 + " TEXT )" );
    }

    /**
     * insertData method for inserting data to database
     * @param data
     * */
    public boolean insertData(String[] data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, data[0]);
        contentValues.put(COL_2, data[1]);
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }

    /**
     * getaAllData method fot returning consisting data from database
     * @return Cursor
     * */
    public Cursor getAllData(){
        return this.getWritableDatabase().rawQuery("select * from " + TABLE_NAME, null);
    }

    /**
     * onUpgrade method call to check if database of same name in same package already exists
     * then drop it
     * @param sqLiteDatabase
     * @param i
     * @param i1
     * */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}