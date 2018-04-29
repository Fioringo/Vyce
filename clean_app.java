package com.florian.andrey.clean;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import java.io.CharArrayWriter;
import java.text.DateFormat;
import java.util.Date;

//import static com.florian.andrey.clean.R.layout.activity_clean_app_main;
//import android.view.MotionEvent;

/*
    This App is by:
        Jonathan Trachtenberg - Hebrew Hammer
        Andrey Shtukenberg    - Chocolate Spaghet Wrangler
        Ismail Kheir          - Ish the Bish
        Shadman Quazi         - The Case Study
        Saif Shakur           - Saif
        Noah Gaffney          - The Bulldozer

 */


public class clean_app extends AppCompatActivity implements GestureDetector.OnGestureListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView dateTime;
    private Button mPanic;
    private TextView stats;
    private int dailyCigs = 10;
    private int cigsLeft = 10;
    private TextView cigText;
    public float mSaved = 0f;
    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //moneySaved();
        cigsLeft = dailyCigs;
        int loggedIn = 1;
        int loggeDay = 0;
        if(loggedIn == 0){
            Intent logIn = new Intent(this, clean_login.class);
            //logIn.putExtra("callingActivity", "MainActivity");
            startActivityForResult(logIn, loggedIn);
        } else {
            setContentView(R.layout.activity_clean_app_main);
        }
        if(loggeDay == 0){
        }

        String dailyCigarets = "Cigarettes Left Today: " + Integer.toString(cigsLeft);
        TextView dCigarets = findViewById(R.id.DailyCigarettes);
        dCigarets.setText(dailyCigarets);

        String theNumber = Float.toString(mSaved);
        char[] num = theNumber.toCharArray();
        boolean encounteredDot = false;
        int counter = 0;
        for (int i = 0; i < theNumber.length(); i++) {
            if(encounteredDot){
                counter++;
            }
            if (num[i] == '.')
                encounteredDot = true;
        }
        if(counter==1){
            theNumber += "0";
        }

        // Display CigsLeft
        //DisplayCiggies();

        stats = findViewById(R.id.stats);
        String string = "$" + theNumber + " saved!";
        stats.setText(string);

        dateTime = findViewById(R.id.date);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        dateTime.setText(currentDateTimeString);
        detector = new GestureDetectorCompat(this, this);

        mPanic = findViewById(R.id.Panic);
        mPanic.setOnClickListener(new View.OnClickListener() {
            public static final int REQUEST_PHONE_CALL = 0;

            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(clean_app.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(clean_app.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                }
                else
                {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:18569064281"));
                    startActivity(callIntent);

                }

            }
        });
    }

    // Called Each Time the user smokes a cig
    public void SmokedOne (View view) {
        if (cigsLeft > 0)
            cigsLeft--;
        String dailyCigarets = "Cigarettes Left Today: " + Integer.toString(cigsLeft);
        TextView dCigarets = findViewById(R.id.DailyCigarettes);
        dCigarets.setText(dailyCigarets);
        //DisplayCiggies();
    }

    public void switchRightView(View view){
        Intent switchRightView = new Intent(this, clean_right.class);
        //switchRightView.putExtra("callingActivity", "MainActivity");
        startActivity(switchRightView);
    }

    public void switchLeftView(View view){
        Intent switchLeftView = new Intent(this, clean_left.class);
        startActivity(switchLeftView);
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
        if(e1.getRawX() < e2.getRawX()){
            Intent switchLeftView = new Intent(this, clean_left.class);
            startActivity(switchLeftView);
        }
        if(e1.getRawX() > e2.getRawX()){
            Intent switchRightView = new Intent(this, clean_right.class);
            startActivity(switchRightView);
        }

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
