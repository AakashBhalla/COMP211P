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

    String p1, p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_questions);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            p1 = extras.getString("p1");
            p2 = extras.getString("p2");

            TextView textView = (TextView) findViewById(R.id.playername);
            textView.setText(p1 + " - answer 10 questions!");

        }
    }
    public void onStartClick(View view) {
        Intent intent = new Intent(this, MultiplayerQuestions2.class);
        intent.putExtra("p1", p1);
        intent.putExtra("p2", p2);
        startActivity(intent);
    }
}



