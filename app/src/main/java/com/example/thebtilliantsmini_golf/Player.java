package com.example.thebtilliantsmini_golf;

import java.io.Serializable;

public class Player implements Serializable {
    private String content;
    String Playername;
    String color;
    int score;
    int colorListPosition;

    public int getColorListPosition() {
        return colorListPosition;
    }

    public void setColorListPosition(int colorListPosition) {
        this.colorListPosition = colorListPosition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlayername() {
        return Playername;
    }

    public void setPlayername(String playername) {
        Playername = playername;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}