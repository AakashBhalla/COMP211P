package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplayerQuestions extends AppCompatActivity {

    private int QuestionNo;
    public int p1score;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_questions);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String p1name = extras.getString("p1");
            String p2name = extras.getString("p2");

            TextView textView = (TextView) findViewById(R.id.playername);
            textView.setText(p1name + " - answer 10 questions!");

        }


    }
}



