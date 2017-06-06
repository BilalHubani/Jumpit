package com.example.billy.jumpit.controller.managers;

import com.example.billy.jumpit.model.UserCustomAtributes;

import java.util.List;

public interface UserCallback {
    void onSucces();
    void onSucces(UserCustomAtributes user);
    void onFailure(Throwable t);
}
