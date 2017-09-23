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

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zainm on 21-Sep-17.
 */

public class DataController {

    public static NotesDatabase notesDatabase;
    public static List<String[]> listOfNotes = new ArrayList();

    public static void initDatabase(Context context){

        if(!listOfNotes.isEmpty()) return;
        notesDatabase = new NotesDatabase(context);
        Cursor cursor = notesDatabase.getAllData();
        if(cursor.moveToFirst()) {
            do {
                listOfNotes.add(new String[]{cursor.getString(cursor.getColumnIndex("notepad")), cursor.getString(cursor.getColumnIndex("time"))});
            } while ((cursor.moveToNext()));
        }
    }
}