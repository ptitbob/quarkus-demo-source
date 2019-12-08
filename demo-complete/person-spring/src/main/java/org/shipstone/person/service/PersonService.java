package org.shipstone.person.service;

import org.shipstone.person.domain.Person;
import org.shipstone.person.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional()
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Transactional(readOnly = true)
  public List<Person> getAll(Boolean active) {
    if (active == null) {
      return personRepository.findAll();
    }
    return personRepository.findAllActive(active);
  }

  @Transactional(readOnly = true)
  public Person findByLogin(String login) {
    return personRepository.findByLogin(login);
  }

  @Transactional
  public Person create(Person person) {
    personRepository.save(person);
    return person;
  }

  @Transactional
  public Person update(Person person, Person personToUpdate) {
    person.setFirstname(personToUpdate.getFirstname());
    person.setLastname(personToUpdate.getLastname());
    person.setActive(personToUpdate.getActive());
    personRepository.save(person);
    return person;
  }

  @Transactional
  public Person updateActiveFlag(Person person, Person personToUpdate) {
    person.setActive(personToUpdate.getActive());
    personRepository.save(person);
    return person;
  }

  public void deletePerson(Person person) {
    personRepository.delete(person);
  }
}
