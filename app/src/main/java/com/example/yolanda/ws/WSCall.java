package com.example.yolanda.ws;

import com.example.yolanda.data.Localizacion;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yolanda on 16/03/2016.,
 */
public class WSCall {
    private static String URL_BASE ="http://api.geonames.org/";
    private static String USERNAME="ilgeonamessample";
    //private static String USERNAME="demo";

    public static String getGeoInfo(String ciudad) throws IOException, JSONException {
        //http://api.geonames.org/searchJSON?q=Madrid&maxRows=20&startRow=0&lang=en&isNameRequired=true&style=FULL&username=ilgeonamessample
        String urlString=URL_BASE+"searchJSON?q="+ciudad+"&maxRows=20&startRow=0&lang=en&isNameRequired=true&style=FULL&username="+USERNAME;
        URL url =new URL(urlString);

        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setRequestProperty("Content-type","application/json");

        BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response=new StringBuffer();
        while((inputLine=in.readLine())!=null){
            response.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return response.toString();

    }

    public static String getMeteoInfo(Localizacion l) throws IOException {
        //http://api.geonames.org/weatherJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo
        String urlString=URL_BASE+"weatherJSON?north="+l.getLimNorth()+"&south="+l.getLimSouth()+"&east="+l.getLimEast()+"&west="+l.getLimWest()+"username"+USERNAME;
        URL url =new URL(urlString);

        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setRequestProperty("Content-type","application/json");

        BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response=new StringBuffer();
        while((inputLine=in.readLine())!=null){
            response.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return response.toString();
    }
}
