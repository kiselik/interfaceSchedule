package com.example.asus.schedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //String[] type_of_people = {"студент","преподаватель"};
        // настройка адаптера
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.type_of_people,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //его подгрузка
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Кто же ты?)");
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getApplicationContext(), "Твой выбор: " + spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
