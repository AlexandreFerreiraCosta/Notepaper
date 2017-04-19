package com.example.alexandre.notepaper;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentCalendario extends Fragment {
    View v;
    CalendarView calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.activity_calendario, container, false);


        TextView txt = (TextView) v.findViewById(R.id.textView3);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "bb.ttf");
        txt.setTypeface(font);

        initializeCalendar();

        return v;
    }

    public void initializeCalendar() {
        calendar = (CalendarView) v.findViewById(R.id.calendar);

        calendar.setShowWeekNumber(false);

        calendar.setFirstDayOfWeek(2);

        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.green));

        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.transparent));

        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.transparent));

        calendar.setSelectedDateVerticalBar(R.color.darkgreen);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                //Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }
}
