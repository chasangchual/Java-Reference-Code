package com.ethan.rest.dummy.openweatherweb;

import com.ethan.rest.dummy.openweatherweb.entity.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ethan on 2016-01-21.
 */
public class WeatherHelper {
    public static CurrentWeather getDummy() {
        CurrentWeather current = new CurrentWeather() ;

        current.setId(5950267);
        current.setName("Etobicoke");
        current.setCod(200) ;
        current.setBase("cmc stations");
        current.setDt(1453432190L);

        Coordinate coord = new Coordinate() ;
        coord.setLongitude(-79.57);
        coord.setLatitude(43.65);

        Weather weather = new Weather() ;
        weather.setId(803);
        weather.setMain("Clouds");
        weather.setDescription("broken clouds");
        weather.setIcon("04n");

        Main main = new Main() ;
        main.setTemp(267.69);
        main.setPressure(1027.0);
        main.setHumidity(57);
        main.setTempMin(265.15);
        main.setTempMax(269.15);

        Wind wind = new Wind() ;
        wind.setSpeed(3.1);
        wind.setDeg(360.0);

        Clouds cloud = new Clouds();
        cloud.setAll(75);

        Sys sys = new Sys() ;
        sys.setId(3722);
        sys.setType(1);
        sys.setMessage(0.0086);
        sys.setCountry("CA");
        sys.setSunrise(1453466667);
        sys.setSunset(1453500935);

        current.setCoord(coord);
        current.setWeather(new ArrayList<Weather>(Arrays.asList(weather))) ;
        current.setMain(main);
        current.setWind(wind);
        current.setClouds(cloud);
        current.setSys(sys);

        return current ;
    }
}
