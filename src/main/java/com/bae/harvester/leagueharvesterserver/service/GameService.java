package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.entities.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameService {

  void record(Game game);

  Page<Game> findAll(Pageable pageable);
}
