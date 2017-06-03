package com.example.billy.jumpit.controller.managers;

import com.example.billy.jumpit.model.UserPowerUp;

import java.util.List;

/**
 * Created by Yuna114 on 03/06/2017.
 */

public interface UserPowerUpCallback {
    void onSuccess(List<UserPowerUp> userPowerUpsList);
    void onSucces();
    void onSucces(UserPowerUp userPowerUp);
    void onFailure(Throwable t);
}
