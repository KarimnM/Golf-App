package com.example.thebtilliantsmini_golf;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ItemHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView color;
    View background;
    public ItemHolder(@NonNull  View itemView) {
        super(itemView);
    name=itemView.findViewById(R.id.playerName);
    color=itemView.findViewById(R.id.playerColorName);
    background=itemView.findViewById(R.id.rowBackground);


    }
}
