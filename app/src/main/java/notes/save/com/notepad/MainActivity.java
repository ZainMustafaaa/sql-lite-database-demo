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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import notes.save.com.notepad.adapter.CustomListAdapter;
import notes.save.com.notepad.database.DataController;

public class MainActivity extends AppCompatActivity {

    /** declaring listView and addButton variables */
    ListView listView;
    Button addButton;

    /**
     * onCreate method calls when activity start
     * @param savedInstanceState
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** initializing listView and addButton variables */
        listView = (ListView) findViewById(R.id.notesListView);
        addButton = (Button) findViewById(R.id.addButton);

        /**
         * setOnItemCLickListener
         * @param OnItemClickListener
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * override method onItemClick
             * @param adapterView
             * @param i
             * @param l
             * @param view
             * */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /** initializing alertDialog */
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Notes");
                alertDialog.setMessage(DataController.listOfNotes.get(i)[0]);
                alertDialog.show();
            }
        });

        /**
         * set addButton OnClickListener
         * @param OnClickListener
         * */
        addButton.setOnClickListener(new View.OnClickListener() {
            /**
             * override method for onClick method
             * @param view
             * */
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Notes.class));
            }
        });

        /** initializing a tiny database and loading list of notes */
        DataController.initDatabase(this);

        /** calling load method to load data from database to and display it to custom list adapter */
        load();
    }

    /**
     * load method calls to load data from database to list custom adapter
     * */
    public void load(){
        /** initializing custom list adapter  */
        CustomListAdapter customListAdapter = new CustomListAdapter(MainActivity.this, DataController.listOfNotes);
        /** setting up custom list view */
        listView.setAdapter(customListAdapter);
    }
}
