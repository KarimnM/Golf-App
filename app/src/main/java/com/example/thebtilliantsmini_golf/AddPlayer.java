package com.example.thebtilliantsmini_golf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddPlayer extends AppCompatActivity {
    DatabaseHelper mDatabaseHelp;
    EditText text;
    Button Adding;
    Button save;
    ListView addedItems;
    ArrayList<Player> arrayList;
    ArrayList<String> IngredientsNames;
    ArrayAdapter<String> adapter;
    EditText getRecipeName;
    EditText getPlayerName;
    DBManger DB;

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


            arrayList = new ArrayList<Player>();
            adapter = new ArrayAdapter<String>(AddPlayer.this, android.R.layout.simple_list_item_1, IngredientsNames);

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
                 //   Intent i = new Intent(getApplicationContext(), ShowAllRecipes.class);
                  //  startActivity(i);

               }
           });


        }

      //  public void Bakbtnn(View view) {
        //    Intent itent = new Intent(this, ShowAllRecipes.class);
         //   startActivity(itent);
        }





