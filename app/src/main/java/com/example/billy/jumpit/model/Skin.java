package com.example.billy.jumpit.model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skin {

    @SerializedName("attr")
    @Expose
    private String attr;
    @SerializedName("attrValue")
    @Expose
    private Integer attrValue;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("priceGame")
    @Expose
    private Integer priceGame;
    @SerializedName("pricePremium")
    @Expose
    private Integer pricePremium;
    @SerializedName("splashArt")
    @Expose
    private String splashArt;
    @SerializedName("users")
    @Expose
    private List<UserDTO> users = null;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Integer getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(Integer attrValue) {
        this.attrValue = attrValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceGame() {
        return priceGame;
    }

    public void setPriceGame(Integer priceGame) {
        this.priceGame = priceGame;
    }

    public Integer getPricePremium() {
        return pricePremium;
    }

    public void setPricePremium(Integer pricePremium) {
        this.pricePremium = pricePremium;
    }

    public String getSplashArt() {
        return splashArt;
    }

    public void setSplashArt(String splashArt) {
        this.splashArt = splashArt;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

}
