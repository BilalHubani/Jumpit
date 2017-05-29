package com.example.billy.jumpit.model;

import java.util.Date;

/**
 * Created by dam on 29/5/17.
 */

public class UserCustomAtributs {
    private User user;
    private Date birthday;
    private long moneyGame;
    private long moneyPremium;
    private long score;
    private char sex;

    public UserCustomAtributs(User user, Date birthday, long moneyGame, long moneyPremium, long score, char sex) {
        this.user = user;
        this.birthday = birthday;
        this.moneyGame = moneyGame;
        this.moneyPremium = moneyPremium;
        this.score = score;
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getMoneyGame() {
        return moneyGame;
    }

    public void setMoneyGame(long moneyGame) {
        this.moneyGame = moneyGame;
    }

    public long getMoneyPremium() {
        return moneyPremium;
    }

    public void setMoneyPremium(long moneyPremium) {
        this.moneyPremium = moneyPremium;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
