package fr.sihm.demo.quarkus.demospring.configuration;

import fr.sihm.demo.quarkus.demospring.controller.CityResource;
import fr.sihm.demo.quarkus.demospring.controller.HelloResource;
import fr.sihm.demo.quarkus.demospring.repository.CityRepository;
import fr.sihm.demo.quarkus.demospring.service.CityService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

  public JerseyConfiguration() {
    register(HelloResource.class);
    register(CityResource.class);
  }
}
