package com.example.thebtilliantsmini_golf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newgame = findViewById(R.id.newGameButton);
        Button loadgame = findViewById(R.id.loadSGButton);
        Button help = findViewById(R.id.helpButton);


        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlayerActivity();
            }
        });
        loadgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavedGamesActivity();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpActivity();
            }
        });
    }

    void addPlayerActivity(){
        Intent intent = new Intent(this, AddPlayer.class);
        startActivity(intent);
    }


    void SavedGamesActivity(){
        Intent intent = new Intent(this, SavedGameActivity.class);
        startActivity(intent);
    }
    void helpActivity(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}