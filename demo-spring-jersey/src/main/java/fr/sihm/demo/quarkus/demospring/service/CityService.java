package fr.sihm.demo.quarkus.demospring.service;

import fr.sihm.demo.quarkus.demospring.domain.City;
import fr.sihm.demo.quarkus.demospring.repository.CityRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CityService {

  private final CityRepository cityRepository;

  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public List<City> getAll() {
    return cityRepository.findAll();
  }

}
