package org.shipstone.person.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class City implements Serializable {

  private static final long serialVersionUID = 2078207826950364129L;

  private Long id;

  private String inseeId;

  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getInseeId() {
    return inseeId;
  }

  public void setInseeId(String inseeId) {
    this.inseeId = inseeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
