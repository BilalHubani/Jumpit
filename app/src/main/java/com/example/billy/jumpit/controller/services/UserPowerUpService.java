package com.example.billy.jumpit.controller.services;

import com.example.billy.jumpit.model.Skin;
import com.example.billy.jumpit.model.User;
import com.example.billy.jumpit.model.UserPowerUp;

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

public interface UserPowerUpService {
    @GET("/api/user-power-ups")
    Call<List<UserPowerUp>> getAllUserPowerUp(
            @Header("Authorization") String Authorization
    );
    @POST("api/user-power-ups") // Se tiene que cambiar en un interfaz propia
    Call<UserPowerUp> createUserPowerUp(
            @Header("Authorization") String Authorization,
            @Body UserPowerUp userPowerUp);
    @PUT("api/user-power-ups")
    Call<UserPowerUp> updateUserPowerUp(
            @Header("Authorization") String Authorization,
            @Body UserPowerUp userPowerUp);

    @DELETE("api/user-power-ups/{id}")
    Call<Void> deleteUserPowerUp(
            @Header("Authorization") String Authorization,
            @Path("id") Long id);
    @PUT("api/user-power-ups/{idPowerUp}/{quantity}/byPriceGame")
    Call<UserPowerUp> buyUserPowerUpByPriceGame(
            @Header("Authorization") String Authorization,
            @Path("idPowerUp") Long idPowerUp, @Path("quantity") int quantity);
    @PUT("api/user-power-ups/{idPowerUp}/{quantity}/byPricePremium")
    Call<UserPowerUp> buyUserPowerUpByPricePremium(
            @Header("Authorization") String Authorization,
            @Path("idPowerUp") Long idPowerUp,
            @Path("quantity") int quantity);
    @PUT("/user-power-ups/byUser/{idPowerUp}/")
    Call<UserPowerUp> updatePowerUpByUser(
            @Header("Authorization") String Authorization,
            @Path("idPowerUp") Long idPowerUp);
    @GET("/api/user-power-ups/byUser/")
    Call<List<UserPowerUp>> getAllUserPowerUpByUser(
            @Header("Authorization") String Authorization
    );
}
