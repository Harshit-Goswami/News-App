package com.harshit.goswami.newsupdate;

import com.harshit.goswami.newsupdate.Modas.MainModal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiUtilities {
   private static Retrofit retrofit=null;
   public String BaseUrl ="https://newsapi.org/v2/";

public static ApiInterface getapiInterface(){
       if(retrofit == null){
           retrofit =new Retrofit.Builder()
                         .baseUrl("https://newsapi.org/v2/")
                         .addConverterFactory(GsonConverterFactory.create())
                         . build();

       }
       return retrofit.create(ApiInterface.class);
   }

    public interface ApiInterface{
         @GET("top-headlines")//top-headlines
        Call<MainModal> getTopNews(
                @Query("country") String country,
                @Query("pageSize") int pageSize,
                @Query("apiKey") String apiKey
         );

        @GET("top-headlines")
        Call<MainModal> getCategoryNews(
                @Query("country") String country,
                @Query("pageSize") int pageSize,
                @Query("apiKey") String apiKey,
                @Query("category") String category
        );

        @GET("everything")
        Call<MainModal> getSearchNews(
                @Query("q") String query,
                @Query("apiKey") String apiKey
        );
    }
}
