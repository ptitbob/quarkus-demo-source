package org.shipstone.person.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpMethod.GET;

@Repository
public class PingRepository {

  private final String pingServerUrl;

  public PingRepository(
      @Value("${app.server.ping.url}") String pingServerUrl
  ) {
    this.pingServerUrl = pingServerUrl;
  }

  public String getPingMessage() throws Exception {
    if (pingServerUrl == null || "".equals(pingServerUrl.trim())) {
      throw new Exception("URL Serveur Ping inconnue");
    }
    RestTemplate restTemplate = new RestTemplate();
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
        .fromHttpUrl(pingServerUrl);
    try {
      ResponseEntity<String> responseEntity = restTemplate.exchange(
          uriComponentsBuilder.build().toUri(), GET, null, String.class
      );
      if (responseEntity.hasBody()) {
        return responseEntity.getBody();
      }
    } catch (HttpStatusCodeException e) {
      if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
        throw new Exception("Erreur de recupération");
      }
      throw new Exception("Erreur serveur...");
    }
    return null;
  }

}
