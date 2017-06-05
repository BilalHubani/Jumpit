package com.example.billy.jumpit.controller.managers;

import android.util.Log;

import com.example.billy.jumpit.controller.services.UserPowerUpService;
import com.example.billy.jumpit.model.UserPowerUp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Yuna114 on 03/06/2017.
 */

public class UserPowerUpManager {
    private static UserPowerUpManager ourInstance;
    private List<UserPowerUp> userPowerUp;
    private Retrofit retrofit;
    private UserPowerUpService userPowerUpService;

    private UserPowerUpManager() {
        userPowerUpService = retrofit.create(UserPowerUpService.class);
    }

    public static UserPowerUpManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new UserPowerUpManager();
        }

        return ourInstance;
    }


    public synchronized void getAllUserPowerUp(final UserPowerUpCallback userPowerUpCallback) {
        Call<List<UserPowerUp>> call = userPowerUpService.getAllUserPowerUp(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<List<UserPowerUp>>() {
            @Override
            public void onResponse(Call<List<UserPowerUp>> call, Response<List<UserPowerUp>> response) {
                userPowerUp = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    userPowerUpCallback.onSuccess(userPowerUp);
                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<UserPowerUp>> call, Throwable t) {
                Log.e("UserPowerUpManager->", "getAllUserPowerUp()->ERROR: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }

    public synchronized void getAllUserPowerUpByUser(final UserPowerUpCallback userPowerUpCallback) {
        Call<List<UserPowerUp>> call = userPowerUpService.getAllUserPowerUpByUser(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<List<UserPowerUp>>() {
            @Override
            public void onResponse(Call<List<UserPowerUp>> call, Response<List<UserPowerUp>> response) {
                userPowerUp = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    userPowerUpCallback.onSuccess(userPowerUp);
                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<UserPowerUp>> call, Throwable t) {
                Log.e("UserPowerUpManager->", "getAllUserPowerUpByUser()->ERROR: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }

    public UserPowerUp getUserPowerUp(String id) {
        for (UserPowerUp userPowerUp1 : userPowerUp) {
            if (id.equals(userPowerUp1.getId())) {
                return userPowerUp1;
            }
        }

        return null;
    }

    /* POST - CREATE PLAYER */

    public synchronized void createUserPowerUp(final UserPowerUpCallback userPowerUpCallback, UserPowerUp userPowerUp) {
        Call<UserPowerUp> call = userPowerUpService.createUserPowerUp(UserLoginManager.getInstance().getBearerToken(), userPowerUp);
        call.enqueue(new Callback<UserPowerUp>() {
            @Override
            public void onResponse(Call<UserPowerUp> call, Response<UserPowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {

                    Log.e("UserPowerUp->", "createUserPowerUp: OK" + 100);

                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserPowerUp> call, Throwable t) {
                Log.e("UserPowerUpManager->", "createUserPowerUp: " + t);
                userPowerUpCallback.onFailure(t);
            }
        });
    }

    /* PUT - UPDATE Athlete */
    public synchronized void updateUserPowerUp(final UserPowerUpCallback userPowerUpCallback, UserPowerUp userPowerUp) {
        Call <UserPowerUp> call = userPowerUpService.updateUserPowerUp(UserLoginManager.getInstance().getBearerToken() ,userPowerUp);
        call.enqueue(new Callback<UserPowerUp>() {
            @Override
            public void onResponse(Call<UserPowerUp> call, Response<UserPowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("UserPowerUpa->", "updateUserPowerUp: OOK" + 100);

                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserPowerUp> call, Throwable t) {
                Log.e("UserPowerUpManager->", "updateUserPowerUp: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }

    /* DELETE - DELETE USER POWER UP */
    public synchronized void deleteUserPowerUp(final UserPowerUpCallback userPowerUpCallback, Long id) {
        Call <Void> call = userPowerUpService.deleteUserPowerUp(UserLoginManager.getInstance().getBearerToken() ,id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("UserPowerUp->", "Deleted: OK");

                } else{
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("UserManager->", "deleteUserPowerUp: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }
    //COMPRAR POWER UP
    public synchronized void buyPowerUpByPriceGame(final UserPowerUpCallback userPowerUpCallback, UserPowerUp userPowerUp, int quantity) {
        Call <UserPowerUp> call = userPowerUpService.buyUserPowerUpByPriceGame(UserLoginManager.getInstance().getBearerToken() , userPowerUp.getId().longValue(), quantity);
        call.enqueue(new Callback<UserPowerUp>() {
            @Override
            public void onResponse(Call<UserPowerUp> call, Response<UserPowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("BuyPowerUpa->", "buyPowerUp: OOK" + 100);

                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserPowerUp> call, Throwable t) {
                Log.e("BuyPowerUpManager->", "buyPowerUp: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }

    public synchronized void buyPowerUpByPricePremium(final UserPowerUpCallback userPowerUpCallback, UserPowerUp userPowerUp, int quantity) {
        Call <UserPowerUp> call = userPowerUpService.buyUserPowerUpByPricePremium(UserLoginManager.getInstance().getBearerToken() , userPowerUp.getId().longValue(), quantity);
        call.enqueue(new Callback<UserPowerUp>() {
            @Override
            public void onResponse(Call<UserPowerUp> call, Response<UserPowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("BuyPowerUpa->", "buyPowerUp: OOK" + 100);

                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserPowerUp> call, Throwable t) {
                Log.e("BuyPowerUpManager->", "buyPowerUp: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }
    //Utilizar una powerUp (elimina 1 a la relación userPowerUp)
    public synchronized void updatePowerUp(final UserPowerUpCallback userPowerUpCallback, UserPowerUp userPowerUp) {
        Call <UserPowerUp> call = userPowerUpService.updatePowerUpByUser(UserLoginManager.getInstance().getBearerToken() , userPowerUp.getPowerUp().getId().longValue());
        call.enqueue(new Callback<UserPowerUp>() {
            @Override
            public void onResponse(Call<UserPowerUp> call, Response<UserPowerUp> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("UsePowerUpa->", "usePowerUp: OOK" + 100);

                } else {
                    userPowerUpCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserPowerUp> call, Throwable t) {
                Log.e("UsePowerUpManager->", "usePowerUp: " + t);

                userPowerUpCallback.onFailure(t);
            }
        });
    }
}
