package fr.sihm.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Person extends PanacheEntity {

	@NotBlank
	@Column(unique = true)
	public String login;

	@Column(name = "firstname")
	@JsonProperty("prenom")
	public String firstname;

	@Column(name = "lastname")
	@JsonProperty("nom")
	public String lastname;

}
