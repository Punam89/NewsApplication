package com.example.newsapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPIInterface {

    @GET("top-headlines")
    Call<DataModel> getNews(@Query("country") String country, @Query("apiKey") String apiKey);

}
