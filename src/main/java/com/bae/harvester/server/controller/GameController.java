package com.bae.harvester.server.controller;

import com.bae.harvester.server.dto.GameDto;
import com.bae.harvester.server.mapper.GameMapper;
import com.bae.harvester.server.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class GameController {

  private final GameMapper gameMapper;
  private final GameService gameService;

  @GetMapping("/api/v1/games")
  public PagedModel<EntityModel<GameDto>> getAll(@PageableDefault(sort = "id") Pageable pageable,
    PagedResourcesAssembler<GameDto> assembler) {
    return assembler.toModel(gameService.findAll(pageable).map(gameMapper::of));
  }
}
