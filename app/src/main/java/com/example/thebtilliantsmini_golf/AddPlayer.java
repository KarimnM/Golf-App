package com.example.thebtilliantsmini_golf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddPlayer extends AppCompatActivity {
    DBHelper mDatabaseHelp;
    EditText text;
    Button Add; //adding add button
    Button Adding;
    Button save;
    ListView addedItems;
    ArrayList<Player> arrayList;
    ArrayList<String> IngredientsNames;
    ArrayAdapter<String> adapter;
    EditText getRecipeName;
    EditText getPlayerName;
    DBManger     DB;
    int  selectedColor=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player2);
        getPlayerName = (EditText) findViewById(R.id.getPlayerName);
        getRecipeName = (EditText) findViewById(R.id.getRecipeName);
        Adding = (Button) findViewById(R.id.Add);
        save = (Button) findViewById(R.id.Save);
        addedItems = (ListView) findViewById(R.id.VV);
        DB = new DBManger(AddPlayer.this);
        IngredientsNames = new ArrayList<>();
        //    mDatabaseHelp = new DatabaseHelper()
        Spinner colorSpinner=findViewById(R.id.colorSpinner);
        String color []=getResources().getStringArray(R.array.color);
        String colorVal []=getResources().getStringArray(R.array.colorVal);
        final List<PlayerColor>colorList=new ArrayList<>();
        for(int i=0; i<color.length;i++){
            colorList.add(new PlayerColor(color[i],colorVal[i]));
        }


        arrayList = new ArrayList<Player>();
        adapter = new ArrayAdapter<String>(AddPlayer.this, android.R.layout.simple_list_item_1, IngredientsNames);
       ArrayAdapter spinnerAdapter = new ArrayAdapter<String>
               (AddPlayer.this, android.R.layout.simple_list_item_1, color);

       colorSpinner.setAdapter(spinnerAdapter);
       colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               selectedColor=position;
               Log.e("Color","name "+colorList.get(selectedColor).getColorName()
                       +" val"+colorList.get(selectedColor).getColorValue());
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

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

                    Player I = new Player();
                    String finaly = getPlayerName.getText().toString();
                    I.setContent(finaly);
                    getPlayerName.setText("");
                    arrayList.add(I);
                    IngredientsNames.add(finaly);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //   Recipe r = new Recipe();
                //  r.setName(getRecipeName.getText().toString());
                // r.setIngredientsList(arrayList);
                // r.setLastUpdate(Calendar.getInstance().getTimeInMillis());
                // DB.insertRecpiToDataBase(r);
                Intent i = new Intent(getApplicationContext(), ScoreboardActivity.class);
                startActivity(i);

            }
        });


    }

}