package com.example.thebtilliantsmini_golf;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<ItemHolder> {
    List<Player>playerList =new ArrayList<>();
     List<PlayerColor>colorList=new ArrayList<>();

    PlayerAdapter(Context ctx){
        String[] color =ctx.getResources().getStringArray(R.array.color);// stores the colors i made in the spinner that are looked in the file called "strings"
        String[] colorVal =ctx.getResources().getStringArray(R.array.colorVal);// give the strings in the array color it's value using hexadecimal. forexample, black = #fff

        for(int i=0; i<color.length;i++){
            colorList.add(new PlayerColor(color[i],colorVal[i]));
        }
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View xmlView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_player,parent,false);
        return new ItemHolder(xmlView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder oneRow, int position) {
            Player player=playerList.get(position);
            oneRow.name.setText(player.Playername);
            oneRow.color.setText(colorList.get(player.getColorListPosition()).getColorName());
            oneRow.background.setBackgroundColor(Color.parseColor(colorList.get(player.getColorListPosition()).getColorValue()));


    }


    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
