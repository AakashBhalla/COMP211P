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

    EditText p1, p2;
    Button startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_register);

        p1 = (EditText)findViewById(R.id.player1);
        p2 = (EditText)findViewById(R.id.player2);
        startbutton = (Button)findViewById(R.id.mstartbutton);
        addData();
    }
    public void addData(){
        startbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String p1 = ((EditText) findViewById(R.id.player1)).getText().toString();
                        String p2 = ((EditText) findViewById(R.id.player2)).getText().toString();
                        Intent intent = new Intent(v.getContext(), MultiplayerQuestions.class);
                        intent.putExtra("p1", p1);
                        intent.putExtra("p2", p2);
                        v.getContext().startActivity(intent);
                        finish();

                    }
                }
        );

    }
}