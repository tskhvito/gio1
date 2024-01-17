package ge.ibsu.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository<City> extends JpaRepository<City, Long> {
}