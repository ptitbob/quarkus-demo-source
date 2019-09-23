package fr.sihm.demo.quarkus.demospring.repository;

import fr.sihm.demo.quarkus.demospring.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
