package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.entities.Game;
import com.bae.harvester.leagueharvesterserver.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GameServiceImpl implements GameService {

  private final GameRepository gameRepository;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void record(Game game) {
    gameRepository.save(game);
  }

  @Override
  public Page<Game> findAll(Pageable pageable) {
    return gameRepository.findAll(pageable);
  }
}
