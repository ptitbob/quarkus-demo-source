package fr.sihm.demo.quarkus.demoquarkus.spring.repository;

import fr.sihm.demo.quarkus.demoquarkus.spring.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  City findByInseeId(String inseeId);

}
