package fr.sihm.demo.quarkus.demoquarkus.spring.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloResource {

  @GetMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
  public String hello() {
    return "Hello";
  }

}
