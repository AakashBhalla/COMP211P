package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreDisplay extends AppCompatActivity {

    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            score = extras.getInt("Score");

            TextView textView = (TextView) findViewById(R.id.QuizComplete);
            textView.setText("Congratulations " + name + "! You have scored " + score + " out of 10!");
        }
    }

    //on home button click
    public void onhomebuttonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

