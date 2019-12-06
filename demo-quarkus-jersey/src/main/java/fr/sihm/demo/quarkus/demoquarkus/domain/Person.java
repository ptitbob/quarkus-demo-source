package fr.sihm.demo.quarkus.demoquarkus.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Person extends PanacheEntity {

  @NotBlank
  @Column(unique = true)
  public String login;

  @Column(name = "firstname")
  public String firstname;

  @Column(name = "lastname")
  public String lastname;

  public Boolean active;

  public static List<Person> listByActiveFlag(Boolean activeFlag) {
    return find("active", activeFlag).list();
  }

}
