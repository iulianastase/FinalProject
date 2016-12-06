package com.services.impl;

import com.model.City;
import com.repository.CityRepository;
import com.services.CityService;
import com.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
/**
 * Created by inastase on 11/24/2016.
 */
public class CityServiceImpl  implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    WeatherService weatherService;



    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findOne(long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City delete(long id) {
        City deletedCity = cityRepository.findOne(id);
        cityRepository.delete(deletedCity);
        return deletedCity;
    }

    @Override
    public City findByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    @Override
    public City updateJson(String cityName) {
        City city =findByCityName(cityName);
        if(city == null){
            city = new City();
            weatherService.jsonParsing(cityName);
            city.setCityName(cityName);
            city.setJsonWeather(weatherService.jsonParsing(cityName).toString());
            this.save(city);
        }
        else
            city.setJsonWeather(weatherService.jsonParsing(cityName).toString());
            return this.save(city);

    }

}
