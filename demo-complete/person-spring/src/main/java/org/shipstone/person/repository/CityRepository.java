package org.shipstone.person.repository;

import org.shipstone.person.dto.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class CityRepository {

  private final String cityServerUrl;

  public CityRepository(
      @Value("${app.server.city.url}") String cityServerUrl
  ) {
    this.cityServerUrl = cityServerUrl;
  }

  public String getCityName(String inseeId) throws Exception {
    if (inseeId == null || "".equals(inseeId.trim())) {
      return null;
    }
    RestTemplate restTemplate = new RestTemplate();
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromHttpUrl(cityServerUrl).path(inseeId);
    try {
      return restTemplate.getForObject(uriComponentsBuilder.build().toUri(), City.class).getName();
    } catch (HttpStatusCodeException e) {
      if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
        throw new Exception("Erreur de recupération de la ville");
      }
      throw new Exception("Erreur serveur...");
    }
  }

}
