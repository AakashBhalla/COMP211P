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
                        p1 = p1.trim();
                        String p2 = ((EditText) findViewById(R.id.player2)).getText().toString();
                        p2 = p2.trim();

                        if (p1.contains("1") ||p1.contains("2") ||p1.contains("3") ||p1.contains("4") ||p1.contains("5") ||p1.contains("6") ||p1.contains("7") ||p1.contains("8") ||p1.contains("9")|| p2.contains("1") ||p2.contains("2") ||p2.contains("3") ||p2.contains("4") ||p2.contains("5") ||p2.contains("6") ||p2.contains("7") ||p2.contains("8") ||p2.contains("9")) {
                            Toast toasty = Toast.makeText(getApplicationContext(), "Your name can't contain numbers!", Toast.LENGTH_LONG);
                            toasty.show();
                            return;
                        }

                        if (p1.isEmpty() || p2.isEmpty()) {
                            Toast toasty = Toast.makeText(getApplicationContext(), "Enter your names!", Toast.LENGTH_LONG);
                            toasty.show();
                            return;
                        }

                        else {
                            Intent intent = new Intent(v.getContext(), MultiplayerQuestions.class);
                            intent.putExtra("p1", p1);
                            intent.putExtra("p2", p2);
                            v.getContext().startActivity(intent);
                            finish();
                        }

                    }
                }
        );

    }
}