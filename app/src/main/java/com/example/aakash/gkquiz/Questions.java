package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Questions extends AppCompatActivity implements View.OnClickListener{

    private boolean done;
    private int QuestionNo;
    public int score=0;
    private int i;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");

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

        ArrayList<Integer> list;
        list = new ArrayList<Integer>();
        list.add(R.id.Q1);
        list.add(R.id.Q2);
        list.add(R.id.Q3);
        list.add(R.id.Q4);
        list.add(R.id.Q5);
        list.add(R.id.Q6);
        list.add(R.id.Q7);
        list.add(R.id.Q8);
        list.add(R.id.Q9);
        list.add(R.id.Q10);

        for (i=0; i< list.size(); i++) {
            String buttonText = ((Button) findViewById(list.get(i))).getText().toString();
            ((Button)findViewById(list.get(i))).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView t = (TextView) findViewById(R.id.question);
                    t.setText(questions[i]);
                    NextButton.setVisibility(View.INVISIBLE);
                    EditText et = (EditText) findViewById(R.id.answer);
                    et.setText("");

                }
            });

    }}}

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

                    Intent intent = new Intent(Questions.this, ScoreDisplay.class);
                    intent.putExtra("Score", score);
                    intent.putExtra("name", name);
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

                        Intent intent = new Intent(Questions.this, ScoreDisplay.class);
                        intent.putExtra("Score", score);
                        intent.putExtra("name", name);
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

    public void onAnswerClick (View view) {
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

}