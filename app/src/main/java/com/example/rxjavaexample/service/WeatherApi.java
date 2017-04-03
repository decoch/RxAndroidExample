package com.example.rxjavaexample.service;

import com.example.rxjavaexample.entity.WeatherEntity;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author akifumi.tominaga
 */
public interface WeatherApi {

    @GET("/data/2.5/{name}")
    public Observable<WeatherEntity> get(@Path("name") String name, @Query("q") String q);
}
