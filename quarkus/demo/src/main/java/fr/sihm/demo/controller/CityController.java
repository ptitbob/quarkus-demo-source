package fr.sihm.demo.controller;

import fr.sihm.demo.dao.CityDao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.ok;

@Path("villes")
public class CityController {

  @Inject
  private CityDao cityDao;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    return ok(cityDao.getAll()).build();
  }

  @GET
  @Path("{insee:\\d{5,6}}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getByInseeId(
      @PathParam("insee") String inseeId
  ) throws Throwable {
    return ok(cityDao.getByInsee(inseeId)).build();
  }

}
