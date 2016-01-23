package com.ethan.rest.dummy.openweatherweb;

import com.ethan.rest.dummy.openweatherweb.entity.CurrentWeather;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ethan on 2016-01-21.
 */
@RestController
public class CurrentWeatherController {
    @RequestMapping("/data/2.5/weather")
    public CurrentWeather greeting(@RequestParam(value="appid", defaultValue="") String appId, @RequestParam(value="q", defaultValue="") String query, @RequestParam(value="id", defaultValue="") String cityId) {
        return WeatherHelper.getDummy() ;
    }
}
