package com.example.billy.jumpit.controller.managers;

import com.example.billy.jumpit.model.PowerUp;

import java.util.List;

/**
 * Created by Yuna114 on 03/06/2017.
 */

public interface PowerUpCallback {
    void onSuccess(List<PowerUp> powerUpsList);
    void onSucces();
    void onSucces(PowerUp powerUp);
    void onFailure(Throwable t);
}
