package fr.sihm.demo.quarkus.demospringmvc.controller;

import fr.sihm.demo.quarkus.demospringmvc.domain.Person;
import fr.sihm.demo.quarkus.demospringmvc.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "personnes", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonResource {

  private final PersonService personService;

  public PersonResource(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public ResponseEntity<List<Person>> getAll(
      @RequestParam(value = "active", required = false) Boolean active
  ) {
    return new ResponseEntity<>(personService.getAll(active), HttpStatus.OK);
  }

  @GetMapping("{login}")
  public Person getPersonByLogin(
      @PathVariable("login") String login
  ) {
    return personService.findByLogin(login);
  }

  @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Person> createPerson(
      @Valid @RequestBody Person person
  ) {
    if (personService.findByLogin(person.getLogin()) == null) {
      personService.create(person);
      return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @PutMapping(value = "{login}", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Person> updatePerson(
      @PathVariable("login") String login,
      @Valid @RequestBody Person personToUpdate
  ) {
    if (!login.equals(personToUpdate.getLogin())) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Person person = personService.findByLogin(login);
    if (person != null) {
      personService.update(person, personToUpdate);
      return new ResponseEntity<>(person, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PatchMapping(value = "{login}", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Person> updateActiveFlag(
      @PathVariable("login") String login,
      @RequestBody Person personToUpdate
  ) {
    if (!login.equals(personToUpdate.getLogin())) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Person person = personService.findByLogin(login);
    if (person != null) {
      personService.updateActiveFlag(person, personToUpdate);
      return new ResponseEntity<>(person, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("{login}")
  public ResponseEntity<Person> deletePerson(
      @PathVariable("login") String login
  ) {
    Person person = personService.findByLogin(login);
    if (person != null) {
      personService.deletePerson(person);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
