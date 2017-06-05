package com.example.billy.jumpit.controller.managers;

import android.util.Log;

import com.example.billy.jumpit.controller.services.SkinService;
import com.example.billy.jumpit.model.Skin;
import com.example.billy.jumpit.util.CustomProperties;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yuna114 on 03/06/2017.
 */

public class SkinManager {
    private static SkinManager ourInstance;
    private List<Skin> skins;
    private Retrofit retrofit;
    private SkinService skinService;

    private SkinManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(CustomProperties.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        skinService = retrofit.create(SkinService.class);
    }

    public static SkinManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new SkinManager();
        }

        return ourInstance;
    }


    public synchronized void getAllSkins(final SkinCallback skinCallback) {
        Call<List<Skin>> call = skinService.getAllSkins(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<List<Skin>>() {
            @Override
            public void onResponse(Call<List<Skin>> call, Response<List<Skin>> response) {
                skins = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    skinCallback.onSuccess(skins);
                } else {
                    skinCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<Skin>> call, Throwable t) {
                Log.e("SkinManager->", "getAllSkins()->ERROR: " + t);
                skinCallback.onFailure(t);
            }
        });
    }

    public Skin getSkin(String id) {
        for (Skin skin : skins) {
            if (id.equals(skin.getId())) {
                return skin;
            }
        }

        return null;
    }

    /* POST - CREATE PLAYER */

    public synchronized void createSkin(final SkinCallback skinCallback,Skin skin) {
        Call<Skin> call = skinService.createSkin(UserLoginManager.getInstance().getBearerToken(), skin);
        call.enqueue(new Callback<Skin>() {
            @Override
            public void onResponse(Call<Skin> call, Response<Skin> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    //playerCallback.onSuccess1(apuestas1x2);
                    Log.e("Skin->", "createSkin: OK" + 100);

                } else {
                    skinCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Skin> call, Throwable t) {
                Log.e("SkinManager->", "createSkin: " + t);
                skinCallback.onFailure(t);
            }
        });
    }

    /* PUT - UPDATE Athlete */
    public synchronized void updateSkin(final SkinCallback skinCallback, Skin skin) {
        Call <Skin> call = skinService.updateSkin(UserLoginManager.getInstance().getBearerToken() , skin);
        call.enqueue(new Callback<Skin>() {
            @Override
            public void onResponse(Call<Skin> call, Response<Skin> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("Skin->", "updateSkin: OOK" + 100);

                } else {
                    skinCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Skin> call, Throwable t) {
                Log.e("UserManager->", "updateUser: " + t);

                skinCallback.onFailure(t);
            }
        });
    }

    /* DELETE - DELETE Skin */
    public synchronized void deleteSkin(final SkinCallback skinCallback, Long id) {
        Call <Void> call = skinService.deleteSkin(UserLoginManager.getInstance().getBearerToken(), id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("User->", "Deleted: OK");

                } else {
                    skinCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("SkinManager->", "deleteSkin: " + t);

               skinCallback.onFailure(t);
            }
        });
    }

    //Comprar Skin
    public synchronized void buySkinByPriceGame(final SkinCallback skinCallback, Skin skin) {
        Call <Skin> call = skinService.buySkinByPriceGame(UserLoginManager.getInstance().getBearerToken() , skin.getId().longValue());
        call.enqueue(new Callback<Skin>() {
            @Override
            public void onResponse(Call<Skin> call, Response<Skin> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("Skin->", "buySkin: OOK" + 100);

                } else {
                    skinCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Skin> call, Throwable t) {
                Log.e("SkinManager->", "buySkinByPriceGame: " + t);

                skinCallback.onFailure(t);
            }
        });
    }
    public synchronized void buySkinByPricePremium(final SkinCallback skinCallback, Skin skin) {
        Call <Skin> call = skinService.buySkinByPricePremium(UserLoginManager.getInstance().getBearerToken() , skin.getId().longValue());
        call.enqueue(new Callback<Skin>() {
            @Override
            public void onResponse(Call<Skin> call, Response<Skin> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("Skin->", "buySkin: OOK" + 100);

                } else {
                    skinCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Skin> call, Throwable t) {
                Log.e("SkinManager->", "buySkinByPricePremium: " + t);

                skinCallback.onFailure(t);
            }
        });
    }

}
