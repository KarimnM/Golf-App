package com.example.thebtilliantsmini_golf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addPlayerActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT1= "com.example.thebtilliantsmini_golf.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2= "com.example.thebtilliantsmini_golf.example.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3= "com.example.thebtilliantsmini_golf.example.EXTRA_TEXT3";
    //EditText player1;
    //EditText player2;
    Button letsPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        //player1 = findViewById(R.id.player1);
        //player2 = findViewById(R.id.player2);
        letsPlay = findViewById(R.id.letsPlay);

        letsPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letsPlay();
            }
        });

    }

    void letsPlay(){
        EditText player1 = findViewById(R.id.player1);
        EditText player2 = findViewById(R.id.player2);
        EditText title = findViewById(R.id.gameTitle);


        String gameTitle = title.getText().toString();
        String player1Text= player1.getText().toString();
        String player2Text = player2.getText().toString();


        Intent intent = new Intent(this, ScoreboardActivity.class);
        intent.putExtra(EXTRA_TEXT1, gameTitle);
        intent.putExtra(EXTRA_TEXT2, player1Text);
        intent.putExtra(EXTRA_TEXT3, player2Text);
        startActivity(intent);
    }

}