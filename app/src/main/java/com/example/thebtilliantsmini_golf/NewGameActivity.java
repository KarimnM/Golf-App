package com.example.thebtilliantsmini_golf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
//Imported imagebutton

import androidx.appcompat.app.AppCompatActivity;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //Creating function for design
    void createDesign(){

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