package com.example.asuper.json;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by bvxcx on 2017/3/6.
 */

public interface GitHubService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://cafenomad.tw/api/v1.1/cafes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("taipei")
    Call<List<Cafe>> listCafes1();




}
