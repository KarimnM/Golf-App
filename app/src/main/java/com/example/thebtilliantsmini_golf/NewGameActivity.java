package com.example.thebtilliantsmini_golf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newgame);
        Button play = findViewById(R.id.letsPlayButton);
        ImageButton hpImBt3 = findViewById(R.id.HPimageBt3);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsPlay();
            }
        });

        hpImBt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
            }
        });

    }

    void letsPlay(){
        Intent intent = new Intent(this, ScoreboardActivity.class);
        startActivity(intent);
    }

    void mainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}