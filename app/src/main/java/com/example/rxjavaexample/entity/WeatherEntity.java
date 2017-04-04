package com.example.rxjavaexample.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author akifumi.tominaga
 */

public class WeatherEntity {

    @Expose
    @SerializedName("pinpointLocations")
    public List<PinpointLocations> pinpointLocations;

    @Expose
    @SerializedName("link")
    public String link;
}
