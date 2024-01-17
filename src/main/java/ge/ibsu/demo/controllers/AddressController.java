package ge.ibsu.demo.controllers;


import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController<AddressService> {
    @Autowired
    private AddressService addressService;

    @Autowired
    private CityService cityService;

    public AddressController(AddressService addressService, CityService cityService) {
        this.addressService = addressService;
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<Object> addAddress(@RequestBody Address address, @RequestParam Long cityId) throws Throwable {
        City city = cityService.getCityById(cityId);
        address.getId(city);
        boolean newAddress = addressService.equals(address);
        return ResponseEntity.ok(newAddress);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Object> updateAddress(@PathVariable Long addressId, @RequestBody Address addressDetails, @RequestParam Long cityId) throws Throwable {
        City city = cityService.getCityById(cityId);
        addressDetails.setCity(city);
        Class<?> updatedAddress = addressService.getClass();
        return ResponseEntity.ok(updatedAddress);
    }

}
