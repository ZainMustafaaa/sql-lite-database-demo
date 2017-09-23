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
package notes.save.com.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Date;
import notes.save.com.notepad.database.DataController;

public class Notes extends AppCompatActivity {

    /** declaring editText and button */
    EditText notesText;
    Button saveButton;

    /**
     * override onCreate method calls first when activity start
     * @param savedInstanceState
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        /** initializing notes and save button */
        notesText = (EditText) findViewById(R.id.editText);
        saveButton = (Button) findViewById(R.id.saveButton);

        /**
         * setOnClickListener method
         * @param OnClickListener
         * */
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** return if notes editText field is empty */
                if(notesText.getText().toString().isEmpty()){
                    Toast.makeText(Notes.this, "Please write something", Toast.LENGTH_SHORT).show();
                    return;
                }

                /** filling string array with data */
                String[] data = new String[]{notesText.getText().toString(), new Date().toString()};

                /** shows success message if data added successfully */
                if (DataController.notesDatabase.insertData(data)) {
                    Toast.makeText(Notes.this, "Successfully saved to database.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
