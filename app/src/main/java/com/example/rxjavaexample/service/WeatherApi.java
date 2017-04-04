package com.example.rxjavaexample.service;

import com.example.rxjavaexample.entity.WeatherEntity;

import io.reactivex.Observable;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author akifumi.tominaga
 */
public interface WeatherApi {

    @GET("/forecast/webservice/json/v1")
    public Observable<WeatherEntity> getWeather(@Query("city") final String city);
}
