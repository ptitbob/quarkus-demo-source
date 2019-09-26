package fr.sihm.demo.quarkus.demospringmvc.service;

import fr.sihm.demo.quarkus.demospringmvc.domain.City;
import fr.sihm.demo.quarkus.demospringmvc.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  private final CityRepository cityRepository;

  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Page<City> getAll(@PageableDefault  Pageable pageable) {
    return cityRepository.findAll(pageable);
  }

  public City getByInseeId(String inseeId) {
    return cityRepository.findByInseeId(inseeId);
  }

}
