package com.example.mynewsapp;

import android.icu.text.CaseMap;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<NewsModel> getAllNews(@Url String url); //Store data in NewsModel and getting news from url

    @GET
    Call<NewsModel> getNewsByCategory(@Url String url);


    }


