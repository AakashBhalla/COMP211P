package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplayerQuestions4 extends AppCompatActivity implements View.OnClickListener{

    private boolean done;
    private int QuestionNo;
    public int p2score=0;
    String p1, p2;
    int p1score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_questions4);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            p1 = extras.getString("p1");
            p2 = extras.getString("p2");
            p1score = extras.getInt("p1score");
            final String[] questions = getResources().getStringArray(R.array.Questions);
            TextView t = (TextView) findViewById(R.id.question);
            t.setText(questions[QuestionNo]);
            final Button NextButton = (Button) findViewById(R.id.NextButton);
            NextButton.setOnClickListener(this);
            NextButton.setVisibility(View.INVISIBLE);
            final Button SkipButton = (Button) findViewById(R.id.SkipButton);
            SkipButton.setOnClickListener(this);
            final Button CheatButton = (Button) findViewById(R.id.CheatButton);
            CheatButton.setOnClickListener(this);
        }
    }

    public void onClick(View v) {

        final Button NextButton = (Button) findViewById(R.id.NextButton);
        final Button SkipButton = (Button) findViewById(R.id.SkipButton);
        final String[] questions = getResources().getStringArray(R.array.Questions);
        switch (v.getId()) {

            case R.id.NextButton:

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

                    Intent intent = new Intent(MultiplayerQuestions4.this, MultiplayerResults.class);
                    intent.putExtra("p1", p1);
                    intent.putExtra("p2", p2);
                    intent.putExtra("p1score", p1score);
                    intent.putExtra("p2score", p2score);
                    startActivity(intent);
                    return;
                }
                break;
            case R.id.SkipButton:

                if (QuestionNo < (questions.length - 1)) {
                    QuestionNo++;
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                    NextButton.setVisibility(View.INVISIBLE);
                    EditText et = (EditText) findViewById(R.id.answer);
                    et.setText("");

                }

                if (QuestionNo == (questions.length - 2)) {
                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[QuestionNo]);
                    NextButton.setVisibility(View.INVISIBLE);
                    EditText et = (EditText) findViewById(R.id.answer);
                    et.setText("");
                    NextButton.setText("Finish");
                    SkipButton.setText("Skip & Finish");
                }

                if (QuestionNo == (questions.length - 1)) {

                    NextButton.setVisibility(View.INVISIBLE);
                    SkipButton.setVisibility(View.INVISIBLE);

                    Intent intent = new Intent(MultiplayerQuestions4.this, MultiplayerResults.class);
                    intent.putExtra("p1", p1);
                    intent.putExtra("p2", p2);
                    intent.putExtra("p1score", p1score);
                    intent.putExtra("p2score", p2score);
                    startActivity(intent);
                    return;
                }
                break;

            case R.id.CheatButton:
                String[] hints = getResources().getStringArray(R.array.Answers);
                Toast toasty = Toast.makeText(getApplicationContext(), hints[QuestionNo], Toast.LENGTH_SHORT);
                toasty.show();

        }

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
            p1score = p1score + 1;

        } else {
            Toast toasty = Toast.makeText(getApplicationContext(), "Nope!", Toast.LENGTH_SHORT);
            toasty.show();
        }
    }
}