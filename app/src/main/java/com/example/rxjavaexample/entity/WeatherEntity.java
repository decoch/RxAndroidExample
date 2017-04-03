package com.example.rxjavaexample.entity;

import java.util.List;

/**
 * @author akifumi.tominaga
 */

public class WeatherEntity {

    public String base;
    public List<Weather> weather;

    public class Weather {
        public int id;
        public String main;
        public String description;
        public String icon;
    }
}