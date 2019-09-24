package fr.sihm.demo.quarkus.demoquarkus.controller;

import fr.sihm.demo.quarkus.demoquarkus.domain.City;
import io.quarkus.panache.common.Sort;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("villes")
public class CityController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<City> getAll() {
    return City.listAll(Sort.by("insee"));
  }

  @GET
  @Path("{insee:\\d{5,6}}")
  @Produces(MediaType.APPLICATION_JSON)
  public City getByInseeId(
      @PathParam("insee") String inseeId
  ) {
    return City.find("insee", inseeId).firstResult();
  }

}
