package com.example.billy.jumpit.model;

/**
 * Created by dam on 29/5/17.
 */

public class Level {
    private int id;
    private String nameLevel;

    public Level(int id, String nameLevel) {
        this.id = id;
        this.nameLevel = nameLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }
}
