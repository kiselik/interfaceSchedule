package com.example.asus.schedule.Helpers;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asus.schedule.R;

public class MyCustomAdapter extends ArrayAdapter<String> {
    private String[] _objects;
    private Context _context;

    public MyCustomAdapter(Context context, int textViewResourceId,
                           String[] objects) {
        super(context, textViewResourceId, objects);
        _objects = objects;
        _context = context;

    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_spiner, parent, false);
        TextView label = (TextView) row.findViewById(R.id.type);
        label.setText(_objects[position]);
        label.setBackgroundColor(_context.getResources().getColor(R.color.colorPrimaryBackgroundLight2));
        return row;
    }
}

