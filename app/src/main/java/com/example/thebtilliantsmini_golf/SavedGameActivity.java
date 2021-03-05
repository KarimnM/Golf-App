package com.example.thebtilliantsmini_golf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SavedGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedgame);
        ImageButton hpImBt2 = findViewById(R.id.HPimageBt2);

        hpImBt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
            }
        });

    }
    void mainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
   }


}
