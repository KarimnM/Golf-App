package com.example.thebtilliantsmini_golf;

import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {


//    TextView hole = findViewById(R.id.holeNum);
//     hole.setText("1");
//    int hole1=Integer.parseInt(hole.getText().toString());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        final PlayerInfoAdapter adapter=new PlayerInfoAdapter(this) ;
        //Created back button
       //TextView back = findViewById(R.id.back);
        Spinner holeSpinner=findViewById(R.id.holeSpinner);
        RecyclerView playerRecycler=findViewById(R.id.playerInfo);
        playerRecycler.setLayoutManager(new LinearLayoutManager(this));
        playerRecycler.setAdapter(adapter);


        ArrayAdapter spinnerAdapter = new ArrayAdapter<String>
                (ScoreboardActivity.this, android.R.layout.simple_list_item_1, getResources()
                        .getStringArray(R.array.number_of_holes));

        holeSpinner.setAdapter(spinnerAdapter);
        holeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (adapter.getSelectedHoleLis()!=null&&position>0){
                    adapter.getSelectedHoleLis().onSelect(position);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<Player> playerList = new ArrayList<Player>();
        if (getIntent()!=null&&getIntent().getExtras()!=null){
            playerList = (ArrayList<Player>)getIntent().getSerializableExtra("PlayerList");
            adapter.setPlayerList(playerList);
        }






        System.out.println("HELLO WORLD!");
    }



}