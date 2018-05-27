package com.example.asus.schedule.Helpers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageButton;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.schedule.R;

public class ExpListAdapter extends BaseExpandableListAdapter {
    private final String LOG_TAG="myLogs";
    private Context ctx;
    private ScheduleAdapterHelper helper;
    private SimpleExpandableListAdapter adapter;

    public ExpListAdapter(Context _ctx, ScheduleAdapterHelper _helper) {
        ctx = _ctx;
        adapter=_helper.getAdapter();
        helper=_helper;
    }

    @Override
    public int getGroupCount() {
        return helper.getGroupData().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Log.d(LOG_TAG,"getChildrenCount " + helper.getChildData().get(groupPosition).size()+ "groupPosition = " + groupPosition);
        return helper.getChildData().get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return helper.getGroupData().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return helper.getGroupData().get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exp_list_group_view, null);
        }
        TextView textGroup = (TextView) convertView.findViewById(R.id.textGroup);
        textGroup.setText(helper.getGroupText(groupPosition));

        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exp_list_child_view, null);
        }

        TextView textChild = (TextView) convertView.findViewById(R.id.textChild);
        textChild.setText(helper.getChildText(groupPosition,childPosition));

        ImageButton button = (ImageButton) convertView.findViewById(R.id.buttonChild);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"button is pressed",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
