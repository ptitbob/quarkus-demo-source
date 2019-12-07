package org.shipstone.quarkus.city.repository;

import org.shipstone.quarkus.city.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  City findByInseeId(String inseeId);

}
