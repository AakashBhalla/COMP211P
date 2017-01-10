package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText name;
    Button startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.playername);
        startbutton = (Button)findViewById(R.id.startbutton);
        addData();
    }
    public void addData(){
        startbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = ((EditText) findViewById(R.id.playername)).getText().toString();
                        name = name.trim();

                        if (name.contains("1") ||name.contains("2") ||name.contains("3") ||name.contains("4") ||name.contains("5") ||name.contains("6") ||name.contains("7") ||name.contains("8") ||name.contains("9")) {
                            Toast toasty = Toast.makeText(getApplicationContext(), "Your name can't contain numbers!", Toast.LENGTH_LONG);
                            toasty.show();
                            return;
                        }

                        if (name.isEmpty()) {
                            Toast toasty = Toast.makeText(getApplicationContext(), "Enter your name!", Toast.LENGTH_LONG);
                            toasty.show();
                            return;
                        }

                        else {
                            Intent intent = new Intent(v.getContext(), Questions.class);
                            intent.putExtra(Constants.CURRENT_NAME, name);
                            v.getContext().startActivity(intent);
                            finish();
                        }

                    }
                }
        );

    }
}