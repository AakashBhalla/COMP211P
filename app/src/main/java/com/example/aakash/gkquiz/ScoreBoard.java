package com.example.aakash.gkquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        TextView ScoreDisplay = (TextView) findViewById(R.id.ScoreDisplay);
        SharedPreferences sp = this.getSharedPreferences("my_prefs", Context.MODE_PRIVATE);

        HighScore[] highScores = LeaderBoardUtil.getHighScores(sp);
        for (int i=0; i<5; i++){
            HighScore score = highScores[i];
            if (score!= null){
                ScoreDisplay.append(i+1 + ". " + score.getName() + " - " + score.getScore() + "\n");
            }
        }
    }

    public void onhomebuttonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}