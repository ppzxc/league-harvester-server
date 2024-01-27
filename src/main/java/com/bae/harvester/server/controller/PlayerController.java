package com.bae.harvester.server.controller;

import com.bae.harvester.server.dto.eog.EndOfGameBlockOriginalDto;
import com.bae.harvester.server.mapper.GameMapper;
import com.bae.harvester.server.mapper.PlayerMapper;
import com.bae.harvester.server.service.GameService;
import com.bae.harvester.server.service.PlayerService;
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
public class PlayerController {

  private final GameMapper gameMapper;
  private final GameService gameService;
  private final PlayerMapper playerMapper;
  private final PlayerService playerService;

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/api/v1/players/{playerId}/games")
//  public void postGame(@PathVariable UUID playerId, @Valid @RequestBody EndOfGameBlockDto endOfGameBlockDto) {
  public void postGame(@PathVariable UUID playerId, @Valid @RequestBody EndOfGameBlockOriginalDto endOfGameBlockOriginalDto) {
    try {
      log.info("{}", new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(endOfGameBlockOriginalDto));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
//    endOfGameBlockOriginalDto

//    log.info("uuid={} summoner.name={} winning={} ranked={} game.type={}", playerId, endOfGameBlockDto.summonerName(),
//      endOfGameBlockDto.winning(), endOfGameBlockDto.ranked(), endOfGameBlockDto.gameType());
//    playerService.recoding(playerMapper.of(endOfGameBlockDto));
//    gameService.recoding(gameMapper.of(endOfGameBlockDto));
  }
}
