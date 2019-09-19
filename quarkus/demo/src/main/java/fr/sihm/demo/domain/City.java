package fr.sihm.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

  @Id
  @Column(name = "id")
  public Long id;

  @Column(name = "insee")
  public String inseeId;

  @Column(name = "nom_maj")
  public String name;

}
