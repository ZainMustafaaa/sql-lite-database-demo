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
package notes.save.com.notepad.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import notes.save.com.notepad.R;

/**
 * Created by zainm on 21-Sep-17.
 */

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    List<String[]> listOfNotes;

    public CustomListAdapter(Context context, List<String[]> listOfNotes) {
        this.context = context;
        this.listOfNotes = listOfNotes;
    }

    @Override
    public int getCount() {
        return listOfNotes.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfNotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) view = view.inflate(context, R.layout.notes_adapter_view, null);
        /** initializing textView */
        TextView listTextView = (TextView) view.findViewById(R.id.contentHereTextView);
        listTextView.setText(listOfNotes.get(i)[0]);
        TextView dateTextView = (TextView) view.findViewById(R.id.dateTextView);
        dateTextView.setText(listOfNotes.get(i)[1]);
        return view;
    }
}