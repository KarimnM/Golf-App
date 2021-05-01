package com.example.thebtilliantsmini_golf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddPlayer extends AppCompatActivity {
    Button Adding;
    Button save;
    ListView addedItems;
    RecyclerView addedItemsRecycler;
    ArrayList<Player> arrayList;
    ArrayList<String> player;
    PlayerAdapter addedPlayerAdapter;
    ArrayAdapter<String> adapter;
    EditText getPlayerName;
    //DBManger DB;
    int  selectedColor=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player2);

        getPlayerName = (EditText) findViewById(R.id.getPlayerName);
        Adding = (Button) findViewById(R.id.Add);
        save = (Button) findViewById(R.id.Save);
        addedItems = (ListView) findViewById(R.id.VVTest);
        addedItemsRecycler =  findViewById(R.id.addPlayerRecycler);
        player = new ArrayList<>();
        Spinner colorSpinner=findViewById(R.id.colorSpinner);



        arrayList = new ArrayList<Player>();
        adapter = new ArrayAdapter<String>(AddPlayer.this, android.R.layout.simple_list_item_1, player);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<String>
                (AddPlayer.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.color));

        colorSpinner.setAdapter(spinnerAdapter);
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedColor=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        addedItemsRecycler.setLayoutManager(new LinearLayoutManager(this));
        addedPlayerAdapter=new PlayerAdapter(this);
        addedItemsRecycler.setAdapter(addedPlayerAdapter);
        addedItems.setAdapter(adapter);
        onBtnClick();

    }

    public void onBtnClick() {
        Adding.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Ingredients
                if(arrayList.size()==4){//allows a maximum of 4 players
                    Toast.makeText(AddPlayer.this, "Maximum of 4 players", Toast.LENGTH_SHORT).show();
                }else if(arrayList.size()<4) {

                    Player player = new Player();
                    String playerNameString = getPlayerName.getText().toString();
                    player.setContent(playerNameString);
                    player.setPlayername(playerNameString);
                    getPlayerName.setText("");
                    player.setColorListPosition(selectedColor);
                    arrayList.add(player);
                    AddPlayer.this.player.add(playerNameString);
                    adapter.notifyDataSetChanged();
                    addedPlayerAdapter.setPlayerList(arrayList);
                }

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(getPlayerName.getWindowToken(),0);
            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), ScoreboardActivity.class);
                i.putExtra("PlayerList", arrayList);
                startActivity(i);

            }
        });


    }
}