package com.example.thebtilliantsmini_golf;

public class Player {

    public enum Color {
        RED, BLUE, YELLOW, GREEN, PURPLE, ORANGE;
    }

    String name;
    int totalScore;
    Color color;
    int score[];

    //Constructor
    public Player(String playerName, Color color){
        name = playerName; //To be given on creation
        totalScore = 0; //Score starts at 0
        this.color = color;
        score = new int[18]; //create array for score of each hole
    }

    //Set player score
    public void setTotalScore() {
        for(int i = 0; i < score.length; i++) {
            totalScore += score[i];
        };
    }

    //Set score for hole
    public void setHoleScore(int hole, int score) {
        this.score[hole-1] = score; //hole-1 because hole 1 is element 0 in array
    }

    //Set ball color
    public void setColor(Color color){
        this.color = color;
    }

    //Set player name
    public void setName(String name){
        this.name = name;
    }

    //Return score for hole
    public int getCurrentHoleScore(int hole) {
        return score[hole - 1];
    }

    //Get Color
    public String getColor() {
        return color.toString();
    }

    //Return total score
    public int getTotalScore() {
        return totalScore;
    }

    //Return name
    public String getName() {
        return name;
    }

}