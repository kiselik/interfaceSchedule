package com.example.asus.schedule.Helpers;

import android.content.Context;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ScheduleAdapterHelper {
    private final String ATTR_GROUP_NAME = "dayName";
    private final String ATTR_SUBJ_NAME = "subjectName";
    
    private String[] days = new String[]{"Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday"};
    //TODO: заполнение по запросу из БД
    private String[] mondaySubject = new String[]{"компьютерное зрение", "деловая речь", "МО", "ИИС"};
    private String[] tuesdaySubject = new String[]{"БЖД", "распределнное программирование", "MO"};
    private String[] wednesdaySubject = new String[]{"TAиФЯ", "TAиФЯ", "МО", "МО"};
    private String[] thursdaySubject = new String[]{"check"};
    private String[] fridaySubject = new String[]{"check 2"};
    private String[] saturdaySubject = new String[]{"спецкурс", "вычислительная геометрия"};
    // коллекция для групп(parents)
    private ArrayList<Map<String, String>> groupData;
    // коллекция для элементов одной группы (children)
    private ArrayList<Map<String, String>> childDataItem;
    // общая коллекция для коллекций элементов
    private ArrayList<ArrayList<Map<String, String>>> childData;

    // список аттрибутов группы или элемента
    private Map<String, String> m;
    private Context ctx;
    private SimpleExpandableListAdapter adapter;

    public ScheduleAdapterHelper(Context _ctx) {
        ctx = _ctx;
    }

    public SimpleExpandableListAdapter getAdapter() {

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String day : days) {
            // заполняем список аттрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put(ATTR_GROUP_NAME, day); // название дня
            groupData.add(m);
        }
        // список аттрибутов групп для чтения
        String groupFrom[] = new String[]{ATTR_GROUP_NAME};
        // список ID view-элементов, в которые будет помещены аттрибуты групп
        int groupTo[] = new int[]{android.R.id.text1};

        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список аттрибутов для каждого элемента
        for (String subj : mondaySubject) {
            m = new HashMap<String, String>();
            m.put(ATTR_SUBJ_NAME, subj); // название телефона
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для второй группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String subj : tuesdaySubject) {
            m = new HashMap<String, String>();
            m.put(ATTR_SUBJ_NAME, subj);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        childDataItem = new ArrayList<Map<String, String>>();
        for (String subj : wednesdaySubject) {
            m = new HashMap<String, String>();
            m.put(ATTR_SUBJ_NAME, subj);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        childDataItem = new ArrayList<Map<String, String>>();
        for (String subj : thursdaySubject) {
            m = new HashMap<String, String>();
            m.put(ATTR_SUBJ_NAME, subj);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        childDataItem = new ArrayList<Map<String, String>>();
        for (String subj : fridaySubject) {
            m = new HashMap<String, String>();
            m.put(ATTR_SUBJ_NAME, subj);
            childDataItem.add(m);
        }

        childDataItem = new ArrayList<Map<String, String>>();
        childData.add(childDataItem);
        for (String subj : saturdaySubject) {
            m = new HashMap<String, String>();
            m.put(ATTR_SUBJ_NAME, subj);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // список аттрибутов элементов для чтения
        String childFrom[] = new String[]{ATTR_SUBJ_NAME};
        // список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[]{android.R.id.text1};

        adapter = new SimpleExpandableListAdapter(
                ctx,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo);

        return adapter;
    }

    public String getGroupText(int groupPos) {
        return ((Map<String, String>) (adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }

    public String getChildText(int groupPos, int childPos) {
        return ((Map<String, String>) (adapter.getChild(groupPos, childPos))).get(ATTR_SUBJ_NAME);
    }

    public String getGroupChildText(int groupPos, int childPos) {
        return getGroupText(groupPos) + " " + getChildText(groupPos, childPos);
    }
}

