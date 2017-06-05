package com.example.billy.jumpit.controller.managers;

import android.util.Log;


import com.example.billy.jumpit.controller.services.UserService;
import com.example.billy.jumpit.model.UserCustomAtributes;
import com.example.billy.jumpit.util.CustomProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserManager {
    private static UserManager ourInstance;
    private List<UserCustomAtributes> users;
    private UserCustomAtributes user;
    private Retrofit retrofit;
    private UserService userService;

    private UserManager() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        retrofit = new Retrofit.Builder()
                .baseUrl(CustomProperties.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))

                .build();

        userService = retrofit.create(UserService.class);
    }

    public static UserManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new UserManager();
        }

        return ourInstance;
    }


    public synchronized void getAllUser(final UserCallback userCallback) {
        Call<List<UserCustomAtributes>> call = userService.getAllUsers(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<List<UserCustomAtributes>>() {
            @Override
            public void onResponse(Call<List<UserCustomAtributes>> call, Response<List<UserCustomAtributes>> response) {
                users = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    userCallback.onSuccess(users);
                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<List<UserCustomAtributes>> call, Throwable t) {
                Log.e("UserManager->", "getAllUser()->ERROR: " + t);

                userCallback.onFailure(t);
            }
        });
    }

    public synchronized void getUserCustomAtributes(final UserCallback userCallback) {
        Call <UserCustomAtributes> call =  userService.userCustomAtributes(UserLoginManager.getInstance().getBearerToken());

        call.enqueue(new Callback<UserCustomAtributes>() {
            @Override
            public void onResponse(Call<UserCustomAtributes> call, Response<UserCustomAtributes> response) {
                user = response.body();

                int code = response.code();

                if (response.isSuccess()) {
                    userCallback.onSuccess(user);
                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserCustomAtributes> call, Throwable t) {
                Log.e("UserManager->", "getAllUser()->ERROR: " + t);

                userCallback.onFailure(t);
            }
        });
    }

    public UserCustomAtributes getUser(String id) {
        for (UserCustomAtributes user : users) {
            if (id.equals(user.getId())) {
                return user;
            }
        }

        return null;
    }

    /* POST - CREATE PLAYER */

    public synchronized void createUser(final UserCallback userCallback, UserCustomAtributes user) {
        Call<UserCustomAtributes> call = userService.createUser(UserLoginManager.getInstance().getBearerToken(), user);
        call.enqueue(new Callback<UserCustomAtributes>() {
            @Override
            public void onResponse(Call<UserCustomAtributes> call, Response<UserCustomAtributes> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    //playerCallback.onSuccess1(apuestas1x2);
                    Log.e("User->", "createUser: OK" + 100);

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserCustomAtributes> call, Throwable t) {
                Log.e("UserManager->", "createUser: " + t);
                userCallback.onFailure(t);
            }
        });
    }

    /* PUT - UPDATE Athlete */
    public synchronized void updateUser(final UserCallback userCallback, UserCustomAtributes user) {
        Call <UserCustomAtributes> call = userService.updateUser(UserLoginManager.getInstance().getBearerToken() ,user);
        call.enqueue(new Callback<UserCustomAtributes>() {
            @Override
            public void onResponse(Call<UserCustomAtributes> call, Response<UserCustomAtributes> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("User->", "updateAthlete: OOK" + 100);

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserCustomAtributes> call, Throwable t) {
                Log.e("UserManager->", "updateUser: " + t);

                userCallback.onFailure(t);
            }
        });
    }

    public synchronized void updateUserScore(final UserCallback userCallback, UserCustomAtributes user, Integer score) {
        Call <UserCustomAtributes> call = userService.updateUserScore(UserLoginManager.getInstance().getBearerToken() ,user, score);
        call.enqueue(new Callback<UserCustomAtributes>() {
            @Override
            public void onResponse(Call<UserCustomAtributes> call, Response<UserCustomAtributes> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("User->", "updateScore: OOK" + 100);

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<UserCustomAtributes> call, Throwable t) {
                Log.e("UserManager->", "updateScore: " + t);

                userCallback.onFailure(t);
            }
        });
    }

    /* DELETE - DELETE PLAYER */
    public synchronized void deleteUser(final UserCallback userCallback, Long id) {
        Call <Void> call = userService.deleteUser(UserLoginManager.getInstance().getBearerToken() ,id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    Log.e("User->", "Deleted: OK");

                } else {
                    userCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("UserManager->", "deleteUser: " + t);

                userCallback.onFailure(t);
            }
        });
    }

}
