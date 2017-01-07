package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        int v = (getIntent().getExtras().getInt("Score")) ;
        TextView textView = (TextView) findViewById(R.id.QuizComplete);
        textView.setText("Congratulations! You have scored " + v + " out of 10!");
    }

    //on home button click
    public void onhomebuttonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

