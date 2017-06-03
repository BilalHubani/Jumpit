package com.example.billy.jumpit.model;

/**
 * Created by Yuna114 on 02/06/2017.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPowerUp {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("powerUp")
    @Expose
    private PowerUp powerUp;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("user")
    @Expose
    private UserDTO user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}