package com.krystianklimek.flowerapp.service;

import com.krystianklimek.flowerapp.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by: Krystian Klimek
 * Date: 23.05.2016.
 */

public interface FlowerService {
    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
