package com.example.aakash.gkquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String name = extras.getString(Constants.CURRENT_NAME);
            int score = extras.getInt(Constants.CURRENT_SCORE);

            TextView textView = (TextView) findViewById(R.id.QuizComplete);

            if (score == 0) {
                textView.setText("Oh Dear " + name + "!!! You scored " + score + " out of 10!");
                textView.setTextSize(35);
            }

            else if  (score !=0 && score< 5) {
                textView.setText("Oh No " + name + "! You only scored " + score + " out of 10!");
                textView.setTextSize(35);
            }

            else if (score >= 5){
                textView.setText("Well Done " + name + "! You scored " + score + " out of 10!");
                textView.setTextSize(35);
            }

            saveHighScore(score, name);
        }


    }

    private void saveHighScore(int myScore, String playerName) {
        SharedPreferences sp = this.getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        HighScore[] highScores = LeaderBoardUtil.getHighScores(sp);

        int currentRank = 5;
        for(int i=4; i>=0; i--){
            HighScore score = highScores[i];
            if (score == null || myScore >= score.getScore()){
                currentRank = i;
            }
            else {
                break;
            }
        }

        if (currentRank >= 5){
            //not a new high score
            return;
        }
        else {
            for (int i=4; i>currentRank; i--) {
                highScores[i] = highScores[i - 1];
            }
            highScores[currentRank] = new HighScore(playerName, myScore);
            LeaderBoardUtil.saveNewHighScores(highScores, sp);
        }
    }


    //on home button click
    public void onhomebuttonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}

