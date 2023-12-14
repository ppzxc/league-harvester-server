package com.bae.harvester.leagueharvesterserver.controller;

import com.bae.harvester.leagueharvesterserver.dto.EndOfGameBlock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class EndOfGameBlockController {

  private final ObjectMapper objectMapper;

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/players/{playerId}/games")
  public void postGame(@PathVariable UUID playerId, @Valid @RequestBody EndOfGameBlock endOfGameBlock)
    throws JsonProcessingException {
    log.info("PUUID: {}", playerId);
    log.info("{}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(endOfGameBlock));
  }
}
