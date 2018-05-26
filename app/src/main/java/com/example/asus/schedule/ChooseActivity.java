package com.example.asus.schedule;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {
    Button next;
    Spinner spinner;
    int _position;
    ArrayAdapter<?> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetings_view);

        adapter /*= ArrayAdapter.createFromResource(this, R.array.type_of_people, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
                adapter = new ArrayAdapter<String>(this,R.layout.spinner_item, R.id.type, R.array.type_of_people);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Кто же ты?");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.rgb(207, 221, 245));
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                ChooseActivity.this._position = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        next = (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (_position) {
                    case 0:
                        Intent intentForStudents = new Intent(getApplicationContext(), ChooseYearActivity.class);
                        startActivity(intentForStudents);
                        break;
                    case 1:
                        Intent intentForTeachers = new Intent(getApplicationContext(), LoginTeachersActivity.class);
                        startActivity(intentForTeachers);
                        break;
                }
            }
        });
    }
}

