package fr.sihm.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
@SequenceGenerator(name="person_sequence",sequenceName="person_sequence", initialValue=200, allocationSize=10)
public class Person extends PanacheEntity {

	@NotBlank
	@Column(unique = true)
	public String login;

	@Column(name = "firstname")
	public String firstname;

	@Column(name = "lastname")
	public String lastname;

}
