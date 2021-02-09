package com.example.coderspot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("photos")
    Call<List<SONGS>> getSONGS();
}