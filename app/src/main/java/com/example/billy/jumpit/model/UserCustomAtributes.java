package com.example.billy.jumpit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCustomAtributes {

    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("moneyGame")
    @Expose
    private Integer moneyGame;
    @SerializedName("moneyPremium")
    @Expose
    private Integer moneyPremium;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("user")
    @Expose
    private UserDTO user;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMoneyGame() {
        return moneyGame;
    }

    public void setMoneyGame(Integer moneyGame) {
        this.moneyGame = moneyGame;
    }

    public Integer getMoneyPremium() {
        return moneyPremium;
    }

    public void setMoneyPremium(Integer moneyPremium) {
        this.moneyPremium = moneyPremium;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}