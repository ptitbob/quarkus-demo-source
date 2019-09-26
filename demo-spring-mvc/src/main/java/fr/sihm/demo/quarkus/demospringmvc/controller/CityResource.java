package fr.sihm.demo.quarkus.demospringmvc.controller;


import fr.sihm.demo.quarkus.demospringmvc.domain.City;
import fr.sihm.demo.quarkus.demospringmvc.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "villes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CityResource {

  private final CityService cityService;

  public CityResource(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping
  public ResponseEntity<List<City>> getAll(
      @PageableDefault(size = 20) Pageable pageable
  ) {
    Page<City> cityPage = cityService.getAll(pageable);
    HttpStatus httpStatus = cityPage.getTotalPages() == 1 ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT;
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.put("x-total-page", Collections.singletonList(String.valueOf(cityPage.getTotalPages())));
    httpHeaders.put("x-total-element", Collections.singletonList(String.valueOf(cityPage.getTotalElements())));
    httpHeaders.put("x-current-page", Collections.singletonList(String.valueOf(cityPage.getPageable().getPageNumber())));
    httpHeaders.put("x-page-size", Collections.singletonList(String.valueOf(cityPage.getPageable().getPageSize())));
    return new ResponseEntity<>(cityPage.getContent(), httpHeaders, httpStatus);
  }

  @GetMapping
  @RequestMapping("{insee}")
  public City getByInseeId(
      @PathVariable("insee") String inseeId
  ) {
    return cityService.getByInseeId(inseeId);
  }

}
