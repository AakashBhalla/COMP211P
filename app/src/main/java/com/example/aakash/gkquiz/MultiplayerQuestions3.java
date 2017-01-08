package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MultiplayerQuestions3 extends AppCompatActivity {

    String p1, p2;
    int p1score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_questions3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            p1 = extras.getString("p1");
            p2 = extras.getString("p2");
            p1score = extras.getInt("p1score");

            TextView textView = (TextView) findViewById(R.id.playername);
            textView.setText(p2 + ", it's your turn!");

        }
    }

    public void onStartClick(View view) {
        Intent intent = new Intent(this, MultiplayerQuestions4.class);
        intent.putExtra("p1", p1);
        intent.putExtra("p2", p2);
        intent.putExtra("p1score", p1score);
        startActivity(intent);
    }

}

