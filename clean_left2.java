package com.florian.andrey.clean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class clean_left2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_app_leftview2);
        Intent start = new Intent(this, RehabResourceMap.class);
        startActivity(start);
    }

    public void changeToCalendar(View view){
        finish();
    }
}
