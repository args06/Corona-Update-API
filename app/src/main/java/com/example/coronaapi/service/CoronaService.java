package com.example.coronaapi.service;

import com.example.coronaapi.CoronaListener;
import com.example.coronaapi.model.CoronaResponse;
import com.example.coronaapi.model.CountriesItem;
import com.example.coronaapi.model.Global;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoronaService {
    private Retrofit retrofit = null;

    public CoronaAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(CoronaAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CoronaAPI.class);
    }

    public void getGlobal(final CoronaListener<Global> listener){
        getAPI().getCorona().enqueue(new Callback<CoronaResponse>() {
            @Override
            public void onResponse(Call<CoronaResponse> call, Response<CoronaResponse> response) {
                CoronaResponse data = response.body();

                if (data != null && data.getGlobal() != null ){
                    listener.onSuccess(data.getGlobal()); //kayak return
                }
            }

            @Override
            public void onFailure(Call<CoronaResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getCountries(final CoronaListener<List<CountriesItem>> listener){
        getAPI().getCorona().enqueue(new Callback<CoronaResponse>() {
            @Override
            public void onResponse(Call<CoronaResponse> call, Response<CoronaResponse> response) {
                CoronaResponse data = response.body();

                if (data != null && data.getGlobal() != null ){
                    listener.onSuccess(data.getCountries()); //kayak return
                }
            }

            @Override
            public void onFailure(Call<CoronaResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
