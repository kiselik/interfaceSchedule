package com.example.asus.schedule;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageButton;

import com.example.asus.schedule.Helpers.ExpListAdapter;
import com.example.asus.schedule.Helpers.ScheduleAdapterHelper;

public class MainActivity extends Activity{
    private final String LOG_TAG = "myLogs";
    private ExpandableListView elvMain;
    private ExpListAdapter myAdapter;
    private ScheduleAdapterHelper helper;
    private ImageButton button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        helper = new ScheduleAdapterHelper(this);
        myAdapter = new ExpListAdapter(this, helper);

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(myAdapter);

        // нажатие на элемент
        elvMain.setOnChildClickListener(new OnChildClickListener() {
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition,   int childPosition, long id) {
                Log.d(LOG_TAG, "onChildClick groupPosition = " + groupPosition +
                        " childPosition = " + childPosition +
                        " id = " + id);
                return false;
            }
        });

        // нажатие на группу
        elvMain.setOnGroupClickListener(new OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Log.d(LOG_TAG, "onGroupClick groupPosition = " + groupPosition +
                        " id = " + id);

                return false;
            }
        });

        // сворачивание группы
        elvMain.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            public void onGroupCollapse(int groupPosition) {
                Log.d(LOG_TAG, "onGroupCollapse groupPosition = " + groupPosition);
            }
        });

        // разворачивание группы
        elvMain.setOnGroupExpandListener(new OnGroupExpandListener() {
            public void onGroupExpand(int groupPosition) {
                    Log.d(LOG_TAG, "onGroupExpand groupPosition = " + groupPosition);
            }
        });
    }
}
