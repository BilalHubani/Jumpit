package com.example.billy.jumpit.model;

import java.util.List;

/**
 * Created by DAM on 23/5/17.
 */

public class User {
    private String userName;
    private String password;
    private String email;
    private long id;
    private int level;
    private List<Skin> skins;
    private List<PowerUp> powerUps;

    public User() {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.id = id;
        this.level = 1;

    }
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public List<Skin> getSkins() {return skins;}
    public void setSkins(List<Skin> skins) {this.skins = skins;}
    public List<PowerUp> getPowerUps() {return powerUps;}
    public void setPowerUps(List<PowerUp> powerUps) {this.powerUps = powerUps;}
}
