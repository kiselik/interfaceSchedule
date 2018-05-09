package com.example.asus.schedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button next;
    Spinner spinner;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.do_choose_activity);

        //Обработчик кнопки Next
        next = (Button) findViewById(R.id.buttonNext);
        next.setOnClickListener(this);

        //Обработчик выпадающего меню
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // настройка адаптера
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.type_of_people, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //его подгрузка
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Кто же ты?)");
    }

    @Override
    public void onClick(View view) {
        //next.setText("эта кнопка была нажата и обработана");
        switch (position){
            case 0:
                Intent intentForStudents= new Intent(this, StudentsDataActivity.class);
                startActivity(intentForStudents);
                break;
            case 1:
                Intent intentForTeachers= new Intent(this, LoginTeachersActivity.class);
                startActivity(intentForTeachers);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        // показываем позиция нажатого элемента
        this.position=position;
        Toast.makeText(getApplicationContext(), "Твой выбор: " + spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
