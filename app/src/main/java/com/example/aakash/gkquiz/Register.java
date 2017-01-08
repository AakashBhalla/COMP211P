package com.example.aakash.gkquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                        Intent intent = new Intent(v.getContext(), Questions.class);
                        intent.putExtra("name", name);
                        v.getContext().startActivity(intent);
                        finish();

                    }
                }
        );

    }
}