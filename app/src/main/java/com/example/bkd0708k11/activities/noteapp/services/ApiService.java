package com.example.bkd0708k11.activities.noteapp.services;

import com.example.bkd0708k11.activities.noteapp.models.DataNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/v2/everything?apiKey=33426eaf1f124fe0b7c3eb9277daa942")
    Call<DataNews> getDataNews(@Query("q") String q);
}
