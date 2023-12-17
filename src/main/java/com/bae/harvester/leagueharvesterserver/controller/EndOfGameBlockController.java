package com.bae.harvester.leagueharvesterserver.controller;

import com.bae.harvester.leagueharvesterserver.dto.EndOfGameBlock;
import com.bae.harvester.leagueharvesterserver.dto.GameDto;
import com.bae.harvester.leagueharvesterserver.mapper.GameMapper;
import com.bae.harvester.leagueharvesterserver.service.GameService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class EndOfGameBlockController {

  private final GameMapper gameMapper;
  private final GameService gameService;

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/players/{playerId}/games")
  public void postGame(@PathVariable UUID playerId, @Valid @RequestBody EndOfGameBlock endOfGameBlock) {
    log.info("uuid={} summoner.name={} winning={} ranked={} game.type={}", playerId, endOfGameBlock.summonerName(),
      endOfGameBlock.winning(), endOfGameBlock.ranked(), endOfGameBlock.gameType());
    gameService.record(gameMapper.of(endOfGameBlock));
  }

  @GetMapping("/games")
  public PagedModel<EntityModel<GameDto>> getAll(@PageableDefault Pageable pageable, PagedResourcesAssembler<GameDto> assembler) {
    return assembler.toModel(gameService.findAll(pageable).map(gameMapper::of));
  }
}
