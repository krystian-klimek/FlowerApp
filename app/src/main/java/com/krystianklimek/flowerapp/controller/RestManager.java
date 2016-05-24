package com.krystianklimek.flowerapp.controller;

import com.krystianklimek.flowerapp.helper.Constants;
import com.krystianklimek.flowerapp.service.FlowerService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by: Krystian Klimek
 * Date: 23.05.2016.
 */

public class RestManager {
    private FlowerService mFlowerService;

    public FlowerService getFlowerService() {
        if (mFlowerService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mFlowerService = retrofit.create(FlowerService.class);
        }
        return mFlowerService;
    }
}
