package fr.sihm.demo.controller;

import fr.sihm.demo.domain.Person;
import io.quarkus.panache.common.Sort;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personnes")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PersonController {

	@GET
	public List<Person> getAllPersons() {
		return Person.listAll(Sort.by("login"));
	}

	@GET
	@Path(("{login}"))
	public Person getPersonByLogin(
		@PathParam("login") String login
	) {
		return Person.find("login", login).firstResult();
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

}
