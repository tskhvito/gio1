package ge.ibsu.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository<Address> extends JpaRepository<Address, Long> {

    <Address, City> List<Address> findByCity(City city);

    <Address> List<Address> findByCity_CityName(String cityName);

    ge.ibsu.demo.entities.Address findOneByAddress(String address);
}
