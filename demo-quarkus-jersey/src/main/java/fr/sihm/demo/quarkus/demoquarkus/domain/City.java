package fr.sihm.demo.quarkus.demoquarkus.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class City extends PanacheEntity {

  @Column(name = "insee")
  public String inseeId;

  @Column(name = "nom_maj")
  public String name;

}
