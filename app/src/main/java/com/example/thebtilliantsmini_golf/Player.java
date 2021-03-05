package com.example.thebtilliantsmini_golf;

public class Player {

    String name;
    int score;

    //Constructor
    public Player(String name, int score){
        name=""; //To be given on creation
        score = 0; //Score starts at 0
    }

    //Set player score
    public void setScore(int newScore){
        score = newScore;
    }
    //Set player name
    public void setName(String newName){
        name = newName;
    }

    //Return score
    public int getScore(){
        return score;
    }
    //Return name
    public String getName() {
        return name;
    }
}
