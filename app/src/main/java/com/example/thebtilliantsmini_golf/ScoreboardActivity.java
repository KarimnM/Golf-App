package com.example.thebtilliantsmini_golf;

//Added some gradle scripts for the compability

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        Button finish_game = findViewById(R.id.finish_game);
        playerRecycler.setLayoutManager(new LinearLayoutManager(this));
        playerRecycler.setAdapter(adapter);

        finish_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


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

    }


    //When the user presses the back button, it goes to the main screen.
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(ScoreboardActivity.this, MainActivity.class));
        finish();

    }

    void openDialog(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Confirm end of the game? ");
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Are you sure?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                goMainScreen();
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ScoreboardActivity.this,"You clicked over No",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    void goMainScreen(){
        Intent intent = new Intent(ScoreboardActivity.this, MainActivity.class);
        startActivity(intent);
    }

}