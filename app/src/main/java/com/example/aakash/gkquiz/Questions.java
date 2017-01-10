package com.example.aakash.gkquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Questions extends AppCompatActivity implements View.OnClickListener{

    private int currentQuestionNum=0;
    private int score=0;
    private int questionsAnswered = 0;
    String name;
    String[] questions;

    private Button nextButton;
    private Button skipButton;
    private EditText ansBox;
    private Button cheatButton;

    final HashMap<Integer, Button> questionToButtonMap = new HashMap<>();

    private static final String FINISH_TAG = "Finish";
    private static final String SKIP_FINISH_TAG = "Skip & Finish";
    private static final String NEXT_TAG = "Next";
    private static final String SKIP_TAG = "Skip";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        nextButton = (Button) findViewById(R.id.NextButton);
        skipButton = (Button) findViewById(R.id.SkipButton);
        ansBox = (EditText) findViewById(R.id.answer);
        cheatButton = (Button) findViewById(R.id.CheatButton);

        questions = getResources().getStringArray(R.array.Questions);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString(Constants.CURRENT_NAME);

            TextView t = (TextView) findViewById(R.id.question);
            t.setText(questions[currentQuestionNum]);
            ansBox.setVisibility(View.VISIBLE);
            nextButton.setOnClickListener(this);
            nextButton.setVisibility(View.INVISIBLE);
            skipButton.setOnClickListener(this);
            cheatButton.setOnClickListener(this);

            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(R.id.Q1);
            ids.add(R.id.Q2);
            ids.add(R.id.Q3);
            ids.add(R.id.Q4);
            ids.add(R.id.Q5);
            ids.add(R.id.Q6);
            ids.add(R.id.Q7);
            ids.add(R.id.Q8);
            ids.add(R.id.Q9);
            ids.add(R.id.Q10);

            for (int i = 0; i < ids.size(); i++) {
                final Integer id = ids.get(i);
                Button button = (Button) findViewById(id);
                button.setId(i);
                questionToButtonMap.put(i, button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Integer viewId = v.getId();
                       currentQuestionNum = viewId;
                       displayQuestion();
                    }
                });
            }
        }
    }


    public void onClick(View v) {

            final String[] questions = getResources().getStringArray(R.array.Questions);
            switch (v.getId()) {
                case R.id.NextButton:
                    if (nextButton.getText().equals((FINISH_TAG))){
                        endGame();
                    }
                    else if (currentQuestionNum < (questions.length)) {
                        displayNextQuestion();
                    }
                    break;
                case R.id.SkipButton:
                    if (skipButton.getText().equals((SKIP_FINISH_TAG))){
                        endGame();
                    }
                    else if (currentQuestionNum < questions.length) {
                        displayNextQuestion();
                    }
                    break;

                case R.id.CheatButton:
                    markCurrentQuestionCheat();
                    String[] hints = getResources().getStringArray(R.array.Answers);
                    Toast toasty = Toast.makeText(getApplicationContext(), hints[currentQuestionNum], Toast.LENGTH_SHORT);
                    toasty.show();
                    ansBox.setVisibility(View.INVISIBLE);
            }

    }

    private void markCurrentQuestionCheat() {
        Button currentQuestionButton = questionToButtonMap.get(currentQuestionNum);
        currentQuestionButton.setBackgroundColor(Color.GRAY);
        currentQuestionButton.setEnabled(false);
        questionsAnswered++;
    }

    private void markCurrentQuestionCorrect() {
        Button currentQuestionButton = questionToButtonMap.get(currentQuestionNum);
        currentQuestionButton.setBackgroundColor(Color.GREEN);
        currentQuestionButton.setTextColor(Color.BLACK);
        currentQuestionButton.setEnabled(false);
        questionsAnswered++;
    }

    private void displayQuestion() {
        final String question = questions[currentQuestionNum];
        TextView t = (TextView) findViewById(R.id.question);
        t.setText(question);

        if (questionsAnswered == (questions.length-1) || currentQuestionNum == (questions.length-1)) {
            nextButton.setText(FINISH_TAG);
            skipButton.setText(SKIP_FINISH_TAG);
        } else {
            nextButton.setText(NEXT_TAG);
            skipButton.setText(SKIP_TAG);
        }
        skipButton.setVisibility(View.VISIBLE);
        cheatButton.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        ansBox.setVisibility(View.VISIBLE);
        ansBox.setEnabled(true);
        EditText et = (EditText) findViewById(R.id.answer);
        et.setText("");


    }

    private void displayNextQuestion() {
        currentQuestionNum++;
        displayQuestion();
    }

    private void endGame() {
        Intent intent = new Intent(Questions.this, ScoreDisplay.class);
        intent.putExtra(Constants.CURRENT_SCORE, score);
        intent.putExtra(Constants.CURRENT_NAME, name);
        startActivity(intent);
        return;
    }

    public void onAnswerClick (View view) {
        String answer = ansBox.getText().toString();
        answer = answer.trim();

        if (answer.isEmpty()){
            return;
        }

        String[] answers = getResources().getStringArray(R.array.Answers);
        String correctanswer = answers[currentQuestionNum];
        correctanswer = correctanswer.toUpperCase();
        answer = answer.toUpperCase();

        if (answer.equals(correctanswer)) {
            score = score + 1;
            Toast toasty = Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT);
            toasty.show();
            nextButton.setVisibility(View.VISIBLE);
            ansBox.setEnabled(false);
            skipButton.setVisibility(View.INVISIBLE);
            cheatButton.setVisibility(View.INVISIBLE);

            markCurrentQuestionCorrect();
        } else {
            Toast toasty = Toast.makeText(getApplicationContext(), "Nope! Try again.", Toast.LENGTH_SHORT);
            toasty.show();
        }
    }

}