package com.example.billy.jumpit.controller.managers;


public interface RegisterCallback {
    void onSuccess();
    void onFailure(Throwable t);
}
