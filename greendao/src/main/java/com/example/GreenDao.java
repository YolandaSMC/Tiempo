package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDao {

    public static void main(String args[])throws Exception{
        Schema schema=new Schema(1,"com.example.yolanda.data");
        addLocalizacion(schema);
        new DaoGenerator().generateAll(schema,".");
    }

    private static void addLocalizacion(Schema s){
        Entity localizacion=s.addEntity("Localizacion");
        localizacion.addLongProperty("id").primaryKey();
        localizacion.addStringProperty("name");

        localizacion.addLongProperty("limSouth");
        localizacion.addLongProperty("limEast");
        localizacion.addLongProperty("limNorth");
        localizacion.addLongProperty("limWest");

        localizacion.addLongProperty("lat");
        localizacion.addLongProperty("lng");


    }
}
