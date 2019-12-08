package org.shipstone.person.controller;

import io.quarkus.panache.common.Sort;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.shipstone.person.domain.Person;
import org.shipstone.person.repository.CityRepository;
import org.shipstone.person.repository.PingRepository;
import org.shipstone.person.repository.domain.City;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personnes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PersonResource {

  @Inject
  @RestClient
  PingRepository pingRepository;

  @Inject
  @RestClient
  CityRepository cityRepository;

  @GET
  public List<Person> getAllPersons(
      @QueryParam("active") Boolean activeFlag,
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("size") @DefaultValue("20") int pageSize
  ) {
    if (activeFlag != null) {
      return Person.listByActiveFlag(activeFlag);
    }
    return Person.listAll(Sort.by("login"));
  }

  @GET
  @Path(("{login}"))
  public Person getPersonByLogin(
      @PathParam("login") String login
  ) {
    Person person = Person.find("login", login).firstResult();
    person.pingMessage = pingRepository.getMessage();
    if (person.cityInsee != null && !"".equals(person.cityInsee.trim())) {
      City city = cityRepository.getCity(person.cityInsee);
      if (city != null) {
        person.cityName = city.name;
      }
    }
    return person;
  }

  @POST
  @Transactional
  public Response createPerson(
      @Valid Person person
  ) {
    if (Person.find("login", person.login).firstResult() == null) {
      person.persist();
      return Response.status(Response.Status.CREATED).entity(person).build();
    }
    return Response.status(Response.Status.BAD_REQUEST).entity("Personne déjà existante").build();
  }

  @PUT
  @Path(("{login}"))
  @Transactional
  public Response updatePerson(
      @PathParam("login") String login,
      @Valid Person personToUpdate
  ) {
    if (!login.equals(personToUpdate.login)) {
      return Response.status(Response.Status.BAD_REQUEST).entity("Le login de l'entité doit être celui du path").build();
    }
    Person person = Person.find("login", login).firstResult();
    if (person != null) {
      person.firstname = personToUpdate.firstname;
      person.lastname = personToUpdate.lastname;
      person.active = personToUpdate.active;
      person.persist();
      return Response.ok(person).build();
    }
    return Response.status(Response.Status.NOT_FOUND).entity("Personne non trouvée").build();
  }

  @PATCH
  @Path(("{login}"))
  @Transactional
  public Response updateActiveFlag(
      @PathParam("login") String login,
      Person personToUpdate
  ) {
    if (!login.equals(personToUpdate.login)) {
      return Response.status(Response.Status.BAD_REQUEST).entity("Le login de l'entité doit être celui du path").build();
    }
    Person person = Person.find("login", login).firstResult();
    if (person != null) {
      person.active = personToUpdate.active;
      person.persist();
      return Response.ok(person).build();
    }
    return Response.status(Response.Status.NOT_FOUND).entity("Personne non trouvée").build();
  }

  @DELETE
  @Path(("{login}"))
  @Transactional
  public Response deletePerson(
      @PathParam("login") String login
  ) {
    Person person = Person.find("login", login).firstResult();
    if (person != null) {
      person.delete();
    }
    return Response.ok().build();
  }

}
