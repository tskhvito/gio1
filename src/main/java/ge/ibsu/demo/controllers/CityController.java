package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<Object> addCity(@RequestBody City city) {
        City newCity = cityService.addCity(city);
        return ResponseEntity.ok(newCity);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<?> removeCity(@PathVariable Long cityId) {
        cityService.removeCity(cityId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<Object> updateCity(@PathVariable Long cityId, @RequestBody City cityDetails) throws Throwable {
        City updatedCity = cityService.updateCity(cityId, cityDetails);
        return ResponseEntity.ok(updatedCity);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<Object> getCityById(@PathVariable Long cityId) throws Throwable {
        City city = cityService.getCityById(cityId);
        return ResponseEntity.ok(city);
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }
}