package com.example.yolanda.ws;

import com.example.yolanda.data.Localizacion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Yolanda on 17/03/2016.
 */
public class DataHandler {
    private Object getGeolocation(String ciudad ) throws IOException, JSONException {
        String resp=WSCall.getGeoInfo(ciudad);
        JSONObject jo=new JSONObject(resp);

        return null;
    }

    private Object getWeather(Localizacion l) throws IOException {
        String resp=WSCall.getMeteoInfo(l);
        return null;
    }

}
