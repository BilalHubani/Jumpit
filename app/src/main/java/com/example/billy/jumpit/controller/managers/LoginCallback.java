package com.example.billy.jumpit.controller.managers;


import com.example.billy.jumpit.controller.services.UserToken;

/**
 * Created by dam on 26/5/17.
 */

public interface LoginCallback {
    void onSuccess(UserToken userToken);
    void onFailure(Throwable t);
}
