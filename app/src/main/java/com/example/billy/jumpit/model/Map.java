package com.example.billy.jumpit.model;

/**
 * Created by dam on 29/5/17.
 */

public class Map {
    private int id;
    private String nameMap;

    public Map(int id, String nameMap) {
        this.id = id;
        this.nameMap = nameMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMap() {
        return nameMap;
    }

    public void setNameMap(String nameMap) {
        this.nameMap = nameMap;
    }
}
