package com.example.asus.schedule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class ChooseYearActivity extends Activity implements NumberPicker.OnValueChangeListener {
    private final String LOG_TAG = "myLogs";
    private TextView tv;
    private Button previous;
    private Button next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_year);

        final NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker1);
        np.setMaxValue(6);
        np.setMinValue(1);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);

        tv = (TextView) findViewById(R.id.choose_year_text);
        next = (Button) findViewById(R.id.choose_year_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"button is pressed",Toast.LENGTH_SHORT).show();
                Intent intentNext = new Intent(getApplicationContext(), ChooseDepartmentActivity.class);
                startActivity(intentNext);
            }
        });

        previous = (Button) findViewById(R.id.choose_year_previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.d(LOG_TAG, "selected year is" + newVal);

    }
}
