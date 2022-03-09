package com.example.bkd0708k11.activities.noteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.bkd0708k11.R;
import com.example.bkd0708k11.activities.noteapp.adapter.AdapterNews;
import com.example.bkd0708k11.activities.noteapp.models.Article;
import com.example.bkd0708k11.activities.noteapp.models.DataNews;
import com.example.bkd0708k11.activities.noteapp.services.ApiService;
import com.example.bkd0708k11.activities.noteapp.services.RestClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityNewsHome extends AppCompatActivity {
    RecyclerView rcListNews;
    ArrayList<Article> articles = new ArrayList<>();
    AdapterNews adapterNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_home);
        rcListNews = findViewById(R.id.rcListNews);
        adapterNews = new AdapterNews(ActivityNewsHome.this, articles);
        rcListNews.setLayoutManager(new LinearLayoutManager(ActivityNewsHome.this, LinearLayoutManager.VERTICAL, false));
        rcListNews.setAdapter(adapterNews);

        ApiService apiService = RestClient.getApiService();
        Call<DataNews> call = apiService.getDataNews("covid");
        call.enqueue(new Callback<DataNews>() {
            @Override
            public void onResponse(Call<DataNews> call, Response<DataNews> response) {
                DataNews dataNews = response.body();
                System.out.println(response.toString());
                ArrayList<Article> respArticles = dataNews.getArticles();
                for (Article article : respArticles
                ) {
                    articles.add(article);
                }

                adapterNews.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataNews> call, Throwable t) {
                Log.d("HUHU", "onFailure: "+t.getMessage());
            }
        });
    }


}