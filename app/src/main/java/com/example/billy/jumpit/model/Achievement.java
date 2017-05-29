package com.example.billy.jumpit.model;

/**
 * Created by dam on 29/5/17.
 */

public class Achievement {
    private int id;
    private String name;
    private long prize;

    public Achievement(int id, String name, long prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrize() {
        return prize;
    }

    public void setPrize(long prize) {
        this.prize = prize;
    }
}
