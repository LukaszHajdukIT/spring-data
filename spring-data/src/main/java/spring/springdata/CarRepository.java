package spring.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarByBrandNotLikeAndPowerLessThan(String brand, int power);

    @Query("select c from Car c where c.engineType = ?1 and c.power > ?2 and c.brand != ?3")
    List<Car> findCarByEngineType(String engineType, int power, String Brand);
}
