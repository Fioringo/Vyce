package com.florian.andrey.clean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ScrollView;

public class clean_questions extends Activity{
    public ScrollView questionScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean_app_questions);
        questionScroll = findViewById(R.id.QuestionsView);
    }

    public void finishQuestions(View view){
        Intent startMain = new Intent(this, clean_app.class);
        startActivity(startMain);
        finish();
    }
}
