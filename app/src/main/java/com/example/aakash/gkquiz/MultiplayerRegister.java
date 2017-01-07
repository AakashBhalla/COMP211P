package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplayerRegister extends AppCompatActivity {

    EditText p1name, p2name;
    Button startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_questions);

        p1name = (EditText)findViewById(R.id.player1);
        p2name = (EditText)findViewById(R.id.player2);
        startbutton = (Button)findViewById(R.id.mstartbutton);
        addData();
    }
    public void addData(){
        startbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }
        );

    }
}