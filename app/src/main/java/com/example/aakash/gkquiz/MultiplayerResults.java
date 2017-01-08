package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MultiplayerResults extends AppCompatActivity {

    String p1, p2;
    int p1score, p2score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            p1 = extras.getString("p1");
            p2 = extras.getString("p2");
            p1score = extras.getInt("p1score");
            p2score = extras.getInt("p2score");

            TextView textView = (TextView) findViewById(R.id.QuizComplete);
            if (p1score < p2score) {
                textView.setText(p1 + " scored " + p1score + " & " + p2 + " scored " + p2score + "." + p2 + " is the winner!");
            }

            if (p1score > p2score) {
                textView.setText(p1 + " scored " + p1score + " & " + p2 + " scored " + p2score + "." + p1 + " is the winner!");
            }

            if (p1score == p2score) {
                textView.setText(p1 + " scored " + p1score + " & " + p2 + " scored " + p2score + ". It's a tie!");
            }
        }
    }

    public void onhomebuttonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        //no longer carrying Strings and variables
        startActivity(intent);
    }

}
