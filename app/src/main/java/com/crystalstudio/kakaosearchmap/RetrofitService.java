package com.crystalstudio.kakaosearchmap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitService {

    @Headers("Authorization: KakaoAK a4ca6699eb1dc19ea5cf05277952caef")
    @GET("/v2/local/search/keyword.json")
    Call<String> searchPlaceByString(@Query("query")String query, @Query("x") String longitude, @Query("y") String latitude);


    @Headers("Authorization: KakaoAK a4ca6699eb1dc19ea5cf05277952caef")
    @GET("/v2/local/search/keyword.json")
    Call<SearchApiResponse> searchPlace(@Query("query")String query, @Query("x") String longitude, @Query("y") String latitude);


}
