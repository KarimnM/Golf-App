package com.example.thebtilliantsmini_golf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
        Button help = findViewById(R.id.helpButton);
        Button resumeGame = findViewById(R.id.loadSGButton);


        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlayerActivity();
            }
        });


        resumeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //IF

                /*If there is currently a game being played, the user will be taken the resumed game
                Otherwise it will display a pop-up message showing that there is no currently
                on-going game
                 */
                noGameDialog();

                //ELSE

                /*
                    Open the Scoreboard Activity with the current score statistics
                 */
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
        Intent intent = new Intent(MainActivity.this, AddPlayer.class);
        startActivity(intent);
    }



    /*
        Method to show the user the message if there is no current ongoing game.
     */
    void noGameDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No current games! Go to NEW GAME");

        //Button specifications
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sameScreen();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



    /*
        Come back to the main screen
     */
    void sameScreen(){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    void helpActivity(){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
}