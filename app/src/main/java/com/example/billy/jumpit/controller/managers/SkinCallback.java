package com.example.billy.jumpit.controller.managers;

import com.example.billy.jumpit.model.Skin;

import java.util.List;

/**
 * Created by Yuna114 on 03/06/2017.
 */

public interface SkinCallback {
    void onSuccess(List<Skin> skinsList);
    void onSucces();
    void onSucces(Skin skin);
    void onFailure(Throwable t);
}
