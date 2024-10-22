package org.shipstone.person.repository;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
@RegisterRestClient
public interface PingRepository {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  String getMessage();

}
