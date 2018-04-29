package com.florian.andrey.clean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class clean_right extends Activity implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_app_rightview);
        detector = new GestureDetectorCompat(this, this);
    }

    public void switchMain(View view){
        Intent switchMain = new Intent(this, clean_app.class);
        startActivity(switchMain);
    }

    public void switchSettings(View view){
        Intent switchSettings = new Intent(this, clean_settings.class);
        startActivity(switchSettings);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getRawX() > e2.getRawX()){
            Intent backToMain = new Intent(this, clean_app.class);
            startActivity(backToMain);
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
