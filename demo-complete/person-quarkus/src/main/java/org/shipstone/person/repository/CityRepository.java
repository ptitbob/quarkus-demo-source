package org.shipstone.person.repository;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.shipstone.person.repository.domain.City;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/villes")
@RegisterRestClient
@Produces({MediaType.APPLICATION_JSON})
public interface CityRepository {

  @GET
  List<City> getCities(int page, int pageSize);

  @GET
  @Path("{insee}")
  City getCity(@PathParam String insee);

}
