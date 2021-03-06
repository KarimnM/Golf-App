package com.example.thebtilliantsmini_golf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ImageButton hpImBt = findViewById(R.id.HPimageBt);

        hpImBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
            }
        });

    }

    void mainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}