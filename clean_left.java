package com.florian.andrey.clean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CalendarView;

public class clean_left extends Activity {

    //private static final String TAG = "CalendarActivity";

    private CalendarView mCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_app_leftview);

        mCalendarView = findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = month + "/" + dayOfMonth + "/" + year;
                // Log.d(TAG, "onSelectedDayChange: date: " + date);

                //Intent intent = new Intent(this, MainActivity.class);
                //intent.putExtra("date", date);
                //startActivity(intent);

            }
        });
    }

    public void switchMain(View view){
        Intent switchMain = new Intent(this, clean_app.class);
        startActivity(switchMain);
    }

    public void switchSettings(View view){
        Intent switchSettings = new Intent(this, clean_settings.class);
        startActivity(switchSettings);
    }

    public void changeToMap(View view){
        Intent changeToMap = new Intent(this, RehabResourceMap.class);
        startActivity(changeToMap);
    }
}
