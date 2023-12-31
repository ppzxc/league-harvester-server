package com.bae.harvester.server.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

  @GetMapping(path = "/")
  public Resource getRoot() {
    return new ClassPathResource("/static/index.html");
  }
}
