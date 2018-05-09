package com.example.asus.schedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentsDataActivity extends AppCompatActivity implements View.OnClickListener {
    private Button next_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        //Обработчик кнопки Next
        next_b = (Button) findViewById(R.id.button);
        next_b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentNext = new Intent(this, MainActivity.class);
        startActivity(intentNext);
    }
}