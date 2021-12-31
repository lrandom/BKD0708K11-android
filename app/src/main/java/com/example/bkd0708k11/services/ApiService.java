package com.example.bkd0708k11.services;

import com.example.bkd0708k11.domains.Note;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("listNote.php")
    Call<ArrayList<Note>> getNotes();

    @POST("addNote.php")
    @FormUrlEncoded
    Call<JSONObject> addNote(@Field("title") String title, @Field("content") String content);

    @GET("deleteNote.php")
    Call<JSONObject> deleteNote(@Query("id") String id);//deleteNote.php?id=<>

    @GET("findById.php")
    Call<Note> findById(@Query("id") String id);//findById.php?id=<>

    @POST("editNote.php")
    @FormUrlEncoded
    Call<JSONObject> editNote(@Field("id") String id,
                              @Field("title") String title,
                              @Field("content") String content);
}
