package com.example.billy.jumpit.controller.services;

import com.example.billy.jumpit.model.PowerUp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Yuna114 on 03/06/2017.
 */

public interface PowerUpService {
    @GET("/api/power-ups")
    Call<List<PowerUp>> getAllPowerUp(
            @Header("Authorization") String Authorization
    );
    @POST("api/power-ups") // Se tiene que cambiar en un interfaz propia
    Call<PowerUp> createPowerUp(
            @Header("Authorization") String Authorization,
            @Body PowerUp powerUp);
    @PUT("api/power-ups")
    Call<PowerUp> updatePowerUp(
            @Header("Authorization") String Authorization,
            @Body PowerUp powerUp);
    @DELETE("api/power-ups/{id}")
    Call<Void> deletePowerUp(
            @Header("Authorization") String Authorization,
            @Path("id") Long id);
}
