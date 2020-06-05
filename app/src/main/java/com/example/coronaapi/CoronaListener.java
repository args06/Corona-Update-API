package com.example.coronaapi;

public interface CoronaListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
