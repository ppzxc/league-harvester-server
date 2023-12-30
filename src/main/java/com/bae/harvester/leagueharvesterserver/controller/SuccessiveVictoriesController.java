package com.bae.harvester.leagueharvesterserver.controller;

import ch.qos.logback.classic.Logger;
import com.bae.harvester.leagueharvesterserver.dto.SuccessiveVictoriesDto;
import com.bae.harvester.leagueharvesterserver.mapper.SuccessiveVictoriesMapper;
import com.bae.harvester.leagueharvesterserver.service.SuccessiveVictoriesService;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class SuccessiveVictoriesController {

  private final SuccessiveVictoriesMapper mapper;
  private final SuccessiveVictoriesService service;

  @GetMapping("/api/v1/successive-victories")
  public List<SuccessiveVictoriesDto> getAll(
    @RequestParam(defaultValue = "#{T(java.time.LocalDate).now()}") LocalDate base) {
    log.info("{}", base);
    return mapper.of(service.findAll(base));
  }
}
