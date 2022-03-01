package com.example.myweather.util;

import android.text.TextUtils;

import com.example.myweather.db.City;
import com.example.myweather.db.County;
import com.example.myweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    public static boolean handleProvinceRequest(String request) {
        if (!TextUtils.isEmpty(request)){
            return false;
        }
        try {
            JSONArray allProvince = new JSONArray(request);
            for (int i = 0; i < allProvince.length(); i++) {
                JSONObject provinceJSONObject = allProvince.getJSONObject(i);
                Province province = new Province();
                province.setProvinceCode(provinceJSONObject.getInt("id"));
                province.setProvinceName(provinceJSONObject.getString("name"));
                province.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCityRequest(String request, int provinceId) {
        if (!TextUtils.isEmpty(request)){
            return false;
        }
        try {
            JSONArray allCities = new JSONArray(request);
            for (int i = 0; i < allCities.length(); i++) {
                JSONObject cityJSONObject = allCities.getJSONObject(i);
                City city = new City();
                city.setCityCode(cityJSONObject.getInt("id"));
                city.setCityName(cityJSONObject.getString("name"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCountyRequest(String request, int cityId) {
        if (!TextUtils.isEmpty(request)){
            return false;
        }
        try {
            JSONArray allCounties = new JSONArray(request);
            for (int i = 0; i < allCounties.length(); i++) {
                JSONObject countyJSONObject = allCounties.getJSONObject(i);
                County county = new County();
                county.setCountyName(countyJSONObject.getString("name"));
                county.setWeatherId(countyJSONObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
