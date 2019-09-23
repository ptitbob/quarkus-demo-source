package fr.sihm.demo.quarkus.demospring.controller;

import fr.sihm.demo.quarkus.demospring.domain.Person;
import fr.sihm.demo.quarkus.demospring.service.PersonService;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

@Component
@Path("personnes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PersonResource {

  private final PersonService personService;

  public PersonResource(PersonService personService) {
    this.personService = personService;
  }

  @GET
  public Response getAll(
      @QueryParam("active") Boolean active
  ) {
    return Response.ok(personService.getAll(active)).build();
  }

  @GET
  @Path(("{login}"))
  public Person getPersonByLogin(
      @PathParam("login") String login
  ) {
    return personService.findByLogin(login);
  }

  @POST
  public Response createPerson(
      @Valid Person person
  ) {
    if (personService.findByLogin(person.getLogin()) == null) {
      personService.create(person);
      return Response.status(Response.Status.CREATED).entity(person).build();
    }
    return Response.status(Response.Status.BAD_REQUEST).entity("Personne déjà existante").build();
  }

  @PUT
  @Path(("{login}"))
  public Response updatePerson(
      @PathParam("login") String login,
      @Valid Person personToUpdate
  ) {
    if (!login.equals(personToUpdate.getLogin())) {
      return Response.status(Response.Status.BAD_REQUEST).entity("Le login de l'entité doit être celui du path").build();
    }
    Person person = personService.findByLogin(login);
    if (person != null) {
      personService.update(person, personToUpdate);
      return Response.ok(person).build();
    }
    return Response.status(Response.Status.NOT_FOUND).entity("Personne non trouvée").build();
  }

  @PATCH
  @Path(("{login}"))
  public Response updateActiveFlag(
      @PathParam("login") String login,
      Person personToUpdate
  ) {
    if (!login.equals(personToUpdate.getLogin())) {
      return Response.status(Response.Status.BAD_REQUEST).entity("Le login de l'entité doit être celui du path").build();
    }
    Person person = personService.findByLogin(login);
    if (person != null) {
      personService.updateActiveFlag(person, personToUpdate);
      return Response.ok(person).build();
    }
    return Response.status(Response.Status.NOT_FOUND).entity("Personne non trouvée").build();
  }

  @DELETE
  @Path(("{login}"))
  public Response deletePerson(
      @PathParam("login") String login
  ) {
    Person person = personService.findByLogin(login);
    if (person != null) {
      personService.deletePerson(person);
    }
    return Response.ok().build();
  }
}
