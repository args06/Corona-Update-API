package com.example.coronaapi.service;

import com.example.coronaapi.model.CoronaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaAPI {
    static final String URL_BASE = "https://api.covid19api.com/";

    @GET("summary")
    Call<CoronaResponse> getCorona();
}
