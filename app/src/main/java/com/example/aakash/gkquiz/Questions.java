package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    private boolean done;
    private int QuestionNo;
    public int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final String[] questions = getResources().getStringArray(R.array.Questions);
        TextView t = (TextView) findViewById(R.id.question);
        t.setText(questions[QuestionNo]);
        final Button NextButton = (Button) findViewById(R.id.NextButton);
        NextButton.setVisibility(View.INVISIBLE);
        final Button SkipButton = (Button) findViewById(R.id.SkipButton);

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (QuestionNo < (questions.length - 1)) {
                    QuestionNo++;
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                    NextButton.setVisibility(View.INVISIBLE);
                    EditText et = (EditText) findViewById(R.id.answer);
                    et.setText("");
                }

                if (QuestionNo == (questions.length - 1)) {
                    NextButton.setText("Finish");
                    SkipButton.setText("Skip & Finish");

                    Intent intent = new Intent(Questions.this, ScoreDisplay.class);
                    intent.putExtra("Score",score);
                    startActivity(intent);

                }

            }
        });

        SkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button skip_button = (Button) findViewById(R.id.SkipButton);
                final Button next_button = (Button) findViewById(R.id.NextButton);

                if (QuestionNo < (questions.length - 1)) {
                    QuestionNo++;
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                    next_button.setVisibility(View.INVISIBLE);
                    EditText et = (EditText) findViewById(R.id.answer);
                    et.setText("");

                }

                if (QuestionNo == (questions.length - 1)) {
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                    next_button.setVisibility(View.INVISIBLE);
                    EditText et = (EditText) findViewById(R.id.answer);
                    et.setText("");
                    next_button.setText("Finish");
                    skip_button.setText("Skip & Finish");
                }

                if (QuestionNo == (questions.length -1)) {

                    Intent intent = new Intent(Questions.this, ScoreDisplay.class);
                    intent.putExtra("Score",score);
                    startActivity(intent);
                    return;

                }
            }
        });
    }


    public void onAnswerClick(View view) {
        String answer = ((EditText) findViewById(R.id.answer)).getText().toString();
        String[] answers = getResources().getStringArray(R.array.Answers);
        String correctanswer = answers[QuestionNo];
        correctanswer = correctanswer.toUpperCase();
        answer = answer.toUpperCase();

        if (answer.equals(correctanswer)) {
            Toast toasty = Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT);
            toasty.show();
            findViewById(R.id.NextButton).setVisibility(View.VISIBLE);
            score = score + 1;

        } else {
            Toast toasty = Toast.makeText(getApplicationContext(), "Nope!", Toast.LENGTH_SHORT);
            toasty.show();
        }
    }

    public void onCheatClick(View view) {

        //when the cheat button is clicked
        String[] hints = getResources().getStringArray(R.array.Answers);
        Toast toasty = Toast.makeText(getApplicationContext(), hints[QuestionNo], Toast.LENGTH_SHORT);
        toasty.show();

    }

}