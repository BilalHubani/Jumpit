package com.example.billy.jumpit.controller.managers;

import android.util.Log;
import com.example.billy.jumpit.model.PowerUp;
import com.example.billy.jumpit.controller.services.PowerUpService;
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

public class PowerUpManager {
    private static PowerUpManager ourInstance;
    private List<PowerUp> powerUp;
    private Retrofit retrofit;
    private PowerUpService powerUpService;

    private PowerUpManager() {
        retrofit = new Retrofit.Builder()
            .baseUrl(CustomProperties.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())

            .build();
        powerUpService = retrofit.create(PowerUpService.class);
    }

    public static PowerUpManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new PowerUpManager();
        }

        return ourInstance;
    }


    public synchronized void getAllPowerUp(final PowerUpCallback powerUpCallback) {
        Call<List<PowerUp>> call = powerUpService.getAllPowerUp(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<List<PowerUp>>() {
            @Override
            public void onResponse(Call<List<PowerUp>> call, Response<List<PowerUp>> response) {
                powerUp = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    powerUpCallback.onSuccess(powerUp);
                } else {
                    powerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<PowerUp>> call, Throwable t) {
                Log.e("UserPowerUpManager->", "getAllUserPowerUp()->ERROR: " + t);

                powerUpCallback.onFailure(t);
            }
        });
    }

    public PowerUp getPowerUp(String id) {
        for (PowerUp powerUp1 : powerUp) {
            if (id.equals(powerUp1.getId())) {
                return powerUp1;
            }
        }

        return null;
    }

    /* POST - CREATE PLAYER */

    public synchronized void createPowerUp(final PowerUpCallback powerUpCallback, PowerUp powerUp) {
        Call<PowerUp> call = powerUpService.createPowerUp(UserLoginManager.getInstance().getBearerToken(), powerUp);
        call.enqueue(new Callback<PowerUp>() {
            @Override
            public void onResponse(Call<PowerUp> call, Response<PowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    //playerCallback.onSuccess1(apuestas1x2);
                    Log.e("PowerUp->", "createPowerUp: OK" + 100);

                } else {
                    powerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<PowerUp> call, Throwable t) {
                Log.e("PowerUpManager->", "createPowerUp: " + t);
                powerUpCallback.onFailure(t);
            }
        });
    }

    /* PUT - UPDATE Athlete */
    public synchronized void updatePowerUp(final PowerUpCallback powerUpCallback, PowerUp powerUp) {
        Call <PowerUp> call = powerUpService.updatePowerUp(UserLoginManager.getInstance().getBearerToken() ,powerUp);
        call.enqueue(new Callback<PowerUp>() {
            @Override
            public void onResponse(Call<PowerUp> call, Response<PowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("PowerUpa->", "updatePowerUp: OOK" + 100);

                } else {
                    powerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<PowerUp> call, Throwable t) {
                Log.e("PowerUpManager->", "updatePowerUp: " + t);

                powerUpCallback.onFailure(t);
            }
        });
    }

    /* DELETE - DELETE USER POWER UP */
    public synchronized void deletePowerUp(final PowerUpCallback powerUpCallback, Long id) {
        Call <Void> call = powerUpService.deletePowerUp(UserLoginManager.getInstance().getBearerToken() ,id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("PowerUp->", "Deleted: OK");

                } else{
                    powerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("UserManager->", "deletePowerUp: " + t);

                powerUpCallback.onFailure(t);
            }
        });
    }
}
