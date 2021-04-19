package com.example.thebtilliantsmini_golf;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;

public class PlayerInfoAdapter extends RecyclerView.Adapter<PlayerInfoAdapter.ItemHolder> {
     List<Player>playerList =new ArrayList<>();
     List<PlayerColor>colorList=new ArrayList<>();

    PlayerInfoAdapter(Context ctx){
        String[] color =ctx.getResources().getStringArray(R.array.color);
        String[] colorVal =ctx.getResources().getStringArray(R.array.colorVal);

        for(int i=0; i<color.length;i++){
            colorList.add(new PlayerColor(color[i],colorVal[i]));
        }
    }
    private SelectedHoleLis selectedHoleLis;

    public SelectedHoleLis getSelectedHoleLis() {
        return selectedHoleLis;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View xmlView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_player_info,parent,false);
        return new ItemHolder(xmlView);
    }
     Player[] player ={null};
    @Override
    public void onBindViewHolder(@NonNull  ItemHolder holder,int position) {
            Player player=playerList.get(position);

            holder.background.setBackgroundColor(Color.parseColor(colorList.get(player.getColorListPosition()).getColorValue()));
            holder.name.setText(player.getPlayername());
            holder.totalScore.setText((""+totalScore(player)));
           
         ArrayAdapter spinnerAdapter = new ArrayAdapter<>
                 (holder.itemView.getContext()
                         , android.R.layout.simple_list_item_1,
                         holder.itemView.getContext().getResources().getStringArray(R.array.number_of_strokes)
                 );
         final int[] spinnerVal = {-1};
        selectedHoleLis = value -> {
                 spinnerVal[0]=value;
            int val = playerList.get(position).getScoreValues().get(""+value);
            Log.e("value",val+""+playerList.get(position).getPlayername());
            if(val!=-1){
                holder.strokSpinner.setSelection(
                Arrays.asList
                        (holder.itemView.getResources().getStringArray(R.array.number_of_strokes))
                        .indexOf(""+val));
            }else {
                holder.strokSpinner.setSelection(0);
            }

        };

        holder.strokSpinner.setAdapter(spinnerAdapter);

        holder.strokSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                player.getScoreValues().put(spinnerVal[0]+"",position);
                holder.totalScore.setText((""+totalScore(player)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private int totalScore(Player p){
        int s=0;
        for(int i=1; i<10;i++){
           int val= p.getScoreValues().get(i+"");

           if(val>-1){
               s=s+val;
           }
        }

        return s;
    }


    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }


    class ItemHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView totalScore;
        Spinner strokSpinner;
        View background;
        public ItemHolder(@NonNull  View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.playerName);
            totalScore=itemView.findViewById(R.id.totalScore);
            background=itemView.findViewById(R.id.rowBackground);
            strokSpinner=itemView.findViewById(R.id.rowStroks);


        }
}
}
