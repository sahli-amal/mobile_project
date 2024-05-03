package com.example.acceuil;

public class Item {
    private int imageResId; // Use Android resource naming convention
    private String text;

    public Item(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }
}
