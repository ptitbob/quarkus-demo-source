package org.shipstone.person.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person implements Serializable {

  private static final long serialVersionUID = 7179658034002172624L;

  @Id @GeneratedValue
  private Long id;

  @NotBlank
  @Column(unique = true)
  private String login;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  private Boolean active;

  @Column(name = "city_insee")
  private String cityInsee;

  // Utilisé pour stocker le message de ping (exemple MicroProfile REST Client 1)
  @Transient
  private String pingMessage;

  @Transient
  private String cityName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getCityInsee() {
    return cityInsee;
  }

  public void setCityInsee(String cityInsee) {
    this.cityInsee = cityInsee;
  }

  public String getPingMessage() {
    return pingMessage;
  }

  public void setPingMessage(String pingMessage) {
    this.pingMessage = pingMessage;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }
}
