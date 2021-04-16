package com.example.thebtilliantsmini_golf;

public class PlayerColor {
   private String ColorName;
    private String ColorValue;

    public PlayerColor() {
    }

    public PlayerColor(String colorName, String colorValue) {
        ColorName = colorName;
        ColorValue = colorValue;
    }

    public String getColorName() {
        return ColorName;
    }

    public String getColorValue() {
        return ColorValue;
    }
}
