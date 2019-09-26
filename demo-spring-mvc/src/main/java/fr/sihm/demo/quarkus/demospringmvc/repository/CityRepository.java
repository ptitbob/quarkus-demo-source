package fr.sihm.demo.quarkus.demospringmvc.repository;

import fr.sihm.demo.quarkus.demospringmvc.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  City findByInseeId(String inseeId);

}
