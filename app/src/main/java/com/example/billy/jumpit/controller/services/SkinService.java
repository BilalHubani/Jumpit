package com.example.billy.jumpit.controller.services;

import com.example.billy.jumpit.model.Skin;

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

public interface SkinService {
    @GET("/api/skins")
    Call<List<Skin>> getAllSkins(
            @Header("Authorization") String Authorization
    );
    @POST("api/skins") // Se tiene que cambiar en un interfaz propia
    Call<Skin> createSkin(
            @Header("Authorization") String Authorization,
            @Body Skin skin);


    @PUT("api/skins")
    Call<Skin> updateSkin(
            @Header("Authorization") String Authorization,
            @Body Skin skin);

    @DELETE("api/skins/{id}")
    Call<Void> deleteSkin(
            @Header("Authorization") String Authorization,
            @Path("id") Long id);

    @PUT("api//skins/{idSkin}/byPriceGame")
    Call<Skin> buySkinByPriceGame(
            @Header("Authorization") String Authorization,
            @Path("idSkin") Long idSkin);
    @PUT("api//skins/{idSkin}/byPricePremium")
    Call<Skin> buySkinByPricePremium(
            @Header("Authorization") String Authorization,
            @Path("idSkin") Long idSkin);
    @GET("/api/skins/byUser")
    Call<List<Skin>> getAllSkinsByUser(
            @Header("Authorization") String Authorization
    );

}
