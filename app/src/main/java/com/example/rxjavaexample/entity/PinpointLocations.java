package com.example.rxjavaexample.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author akifumi.tominaga
 */
public class PinpointLocations {

    @Expose
    @SerializedName("link")
    private String link;

    @Expose
    @SerializedName("name")
    private String name;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}