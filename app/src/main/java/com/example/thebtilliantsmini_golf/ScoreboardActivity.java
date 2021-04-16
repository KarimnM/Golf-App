package com.example.thebtilliantsmini_golf;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {


//    TextView hole = findViewById(R.id.holeNum);
//     hole.setText("1");
//    int hole1=Integer.parseInt(hole.getText().toString());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        //Created back button
        TextView back = findViewById(R.id.back);


        Intent intent = getIntent();
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList = (ArrayList<Player>)getIntent().getSerializableExtra("PlayerList");
//        String title1 = intent.getStringExtra(addPlayerActivity.EXTRA_TEXT1);
//        String player1 = intent.getStringExtra(addPlayerActivity.EXTRA_TEXT2);
//        String player2= intent.getStringExtra(addPlayerActivity.EXTRA_TEXT3);

        TextView gameTitle = findViewById(R.id.gameTitle1);
        TextView Player1 = findViewById(R.id.textView13);
        TextView Player2 = findViewById(R.id.textView14);

//        gameTitle.setText(title1);
        Player1.setText(playerList.get(0).getPlayername());
        Player2.setText(playerList.get(1).getPlayername());





        System.out.println("HELLO WORLD!");
        //System.out.println(title1);
    }



}