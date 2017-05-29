package com.example.billy.jumpit.controller.managers;


import com.example.billy.jumpit.controller.services.RegisterService;
import com.example.billy.jumpit.model.UserDTO;
import com.example.billy.jumpit.util.CustomProperties;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterManager {
    private static RegisterManager ourInstance;
    private Retrofit retrofit;
    private RegisterService registerService;

    private RegisterManager() {

        retrofit = new Retrofit.Builder()
                .baseUrl(CustomProperties.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        registerService = retrofit.create(RegisterService.class);
    }

    public static RegisterManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new RegisterManager();
        }


        return ourInstance;
    }

    /* POST - REGISTER ACCOUNT */

    public synchronized void registerAccount(final RegisterCallback registerCallback, UserDTO userDTO) {
        Call<Void> call = registerService.registerAccount(userDTO);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();

                if (code == 200 || code == 201) {
                    registerCallback.onSuccess();

                } else {
                    registerCallback.onFailure(new Throwable("ERROR" + code + ", " + response.raw().message()));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                registerCallback.onFailure(t);
            }
        });
    }
}
