package com.example.asus.schedule;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.asus.schedule.Helpers.MyCustomAdapter;

public class GreetingsActivity extends AppCompatActivity {
    private String[] type_of_people = {"студент", "преподаватель"};
    private int _position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetings_view);

        final Spinner spinner= (Spinner) findViewById(R.id.spinner);
        MyCustomAdapter adapter = new MyCustomAdapter(GreetingsActivity.this, R.layout.custom_spiner, type_of_people);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Кто же ты?");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos,
                                       long id) {
                GreetingsActivity.this._position = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Button next = (Button) findViewById(R.id.buttonNext);
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

