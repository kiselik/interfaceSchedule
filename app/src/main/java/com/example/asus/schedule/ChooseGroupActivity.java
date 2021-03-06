package com.example.asus.schedule;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.asus.schedule.Helpers.MyCustomAdapter;

public class ChooseGroupActivity extends Activity{

    private String[] groups = {"ПМИ", "ПИ", "ПИНЖ","ФИИТ"};
    private int _position;
    private Button previous;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_group);

        final Spinner spinner= (Spinner) findViewById(R.id.spinner);
        MyCustomAdapter adapter = new MyCustomAdapter(ChooseGroupActivity.this, R.layout.custom_spiner, groups);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {
                ChooseGroupActivity.this._position = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Button next = (Button) findViewById(R.id.group_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"button is pressed",Toast.LENGTH_SHORT).show();
                Intent intentNext = new Intent(getApplicationContext(), ChooseGroupActivity.class);
                startActivity(intentNext);
            }
        });
    }




}
