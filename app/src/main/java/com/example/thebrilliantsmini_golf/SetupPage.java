package com.example.thebrilliantsmini_golf;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class SetupPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setup);

        Button newgame = findViewById(R.id.newGameButton);
        Button loadgame = findViewById(R.id.loadSGButton);
        Button help = findViewById(R.id.helpButton);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGameActivity();
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


    void newGameActivity(){
        Intent intent = new Intent(this, newGameActivity.class);
        startActivity(intent);
    }

    void SavedGamesActivity(){
        Intent intent = new Intent(this, SavedGamesActivity.class);
        startActivity(intent);
    }
    void helpActivity(){
        Intent intent = new Intent(this, helpActivity.class);
        startActivity(intent);
    }


}