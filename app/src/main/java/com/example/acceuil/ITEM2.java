package com.example.acceuil;

public class ITEM2 {
    private int imageResourceId;
    private String name;
    private String profession;
    private String location;

    public ITEM2(int imageResourceId, String name, String profession, String location) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.profession = profession;
        this.location = location;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getLocation() {
        return location;
    }
}
