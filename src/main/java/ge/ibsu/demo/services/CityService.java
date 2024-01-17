package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;


    public City addCity(City city) {
        return (City) cityRepository.save(city);
    }


    public void removeCity(Long cityId) {
        cityRepository.deleteById(cityId);
    }


    public City updateCity(Long cityId, City cityDetails) throws Throwable {
        City city = (City) cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found for id: " + cityId));
        city.setCityName(cityDetails.getCityName());
        return (City) cityRepository.save(city);
    }


    public City getCityById(Long cityId) throws Throwable {
        return (City) cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found for id: " + cityId));
    }

    public <City> List getAllCities() {
        return cityRepository.findAll();
    }
}