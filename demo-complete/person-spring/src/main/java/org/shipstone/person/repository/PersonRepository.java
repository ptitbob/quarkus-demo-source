package org.shipstone.person.repository;

import org.shipstone.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

  @Query(value = "select p from Person p where p.active = :activeValue")
  List<Person> findAllActive(@Param("activeValue") boolean active);

  Person findByLogin(String login);
}
