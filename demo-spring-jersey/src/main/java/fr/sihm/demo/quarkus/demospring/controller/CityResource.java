package fr.sihm.demo.quarkus.demospring.controller;


import fr.sihm.demo.quarkus.demospring.service.CityService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("villes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CityResource {

  private final CityService cityService;

  @Inject
  public CityResource(CityService cityService) {
    this.cityService = cityService;
  }

  @GET
  public Response getAll() {
    return Response.ok().entity(cityService.getAll()).build();
  }

}
