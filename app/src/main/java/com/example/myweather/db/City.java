package com.example.myweather.db;

import org.litepal.crud.DataSupport;

public class City extends DataSupport {

    private int id;
    private int cityCode;
    private String cityName;

    public void setId(int id) {
        this.id = id;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public int getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }
}
