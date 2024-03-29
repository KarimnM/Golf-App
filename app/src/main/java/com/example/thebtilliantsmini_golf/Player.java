package com.example.thebtilliantsmini_golf;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable {
    private String content;
    String Playername;
    String color;
    int score;
    int colorListPosition;

    public Player() {
        for(int i=1; i<10;i++){ // this loops over the number of strokes to define which position in the spinner. for example 1 is defined as string but this loop makes it an integer
            scoreValues.put(i+"",-1);//-1 means the user didnt choose any strokes yet.
        }
    }

    public HashMap<String, Integer> getScoreValues() {
        return scoreValues;
    }

    public void setScoreValues(HashMap<String, Integer> scoreValues) {
        this.scoreValues = scoreValues;
    }

    private HashMap<String ,Integer> scoreValues=new HashMap<>();

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
        //Possibly change this line to fix the "Ball Color" bug
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