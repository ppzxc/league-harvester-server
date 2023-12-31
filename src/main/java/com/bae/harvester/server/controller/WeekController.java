package com.bae.harvester.server.controller;

import com.bae.harvester.server.dto.Weeks;
import com.bae.harvester.server.service.GameService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class WeekController {

  private final GameService gameService;

  @GetMapping("/api/v1/weeks")
  public List<Weeks> getWeeks() {
    return gameService.findWeeks();
  }
}
