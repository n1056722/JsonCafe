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
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);


}
