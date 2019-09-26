package fr.sihm.demo.quarkus.demospring.controller;


import fr.sihm.demo.quarkus.demospring.domain.City;
import fr.sihm.demo.quarkus.demospring.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("villes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CityResource {

  private final CityService cityService;

  public CityResource(CityService cityService) {
    this.cityService = cityService;
  }

  @GET
  public Response getAll(
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("size") @DefaultValue("20") int pageSize

  ) {
    Pageable pageable = PageRequest.of(page, pageSize);
    Page<City> cityPage = cityService.getAll(pageable);
    Response.ResponseBuilder response;
    if (cityPage.getTotalPages() == 1) {
      response = Response.ok(cityPage.getContent());
    } else {
      response = Response.status(Response.Status.PARTIAL_CONTENT).entity(cityPage.getContent());
    }
    response.header("x-total-page", cityPage.getTotalPages());
    response.header("x-total-element", cityPage.getTotalElements());
    response.header("x-current-page", cityPage.getPageable().getPageNumber());
    response.header("x-page-size", cityPage.getPageable().getPageSize());
    return response.build();
  }

  @GET
  @Path("{insee}")
  public City getByInseeId(
      @PathParam("insee") String inseeId
  ) {
    return cityService.getByInseeId(inseeId);
  }

}
