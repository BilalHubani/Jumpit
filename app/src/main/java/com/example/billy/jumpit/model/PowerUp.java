package com.example.billy.jumpit.model;

/**
 * Created by dam on 29/5/17.
 */

public class PowerUp {
    private int id;
    private String name;
    private long priceGame;
    private long pricePremium;
    private String splashArt;

    public PowerUp(int id, String name, long priceGame, long pricePremium, String splashArt) {
        this.id = id;
        this.name = name;
        this.priceGame = priceGame;
        this.pricePremium = pricePremium;
        this.splashArt = splashArt;
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

    public long getPriceGame() {
        return priceGame;
    }

    public void setPriceGame(long priceGame) {
        this.priceGame = priceGame;
    }

    public long getPricePremium() {
        return pricePremium;
    }

    public void setPricePremium(long pricePremium) {
        this.pricePremium = pricePremium;
    }

    public String getSplashArt() {
        return splashArt;
    }

    public void setSplashArt(String splashArt) {
        this.splashArt = splashArt;
    }
}
