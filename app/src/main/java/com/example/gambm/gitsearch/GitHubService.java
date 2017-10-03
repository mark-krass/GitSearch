package com.example.gambm.gitsearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface GitHubService{
    @GET("search/repositories?q=repo")
    Call<List<ReposInfo>> repoContributors(
            @Query("repo") String repo);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}