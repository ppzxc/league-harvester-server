package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.WeekUtils;
import com.bae.harvester.leagueharvesterserver.entities.Game;
import com.bae.harvester.leagueharvesterserver.entities.SuccessiveVictories;
import com.bae.harvester.leagueharvesterserver.repositories.GameRepository;
import com.bae.harvester.leagueharvesterserver.repositories.PlayerRepository;
import com.bae.harvester.leagueharvesterserver.repositories.SuccessiveVictoriesRepository;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class GameServiceImpl implements GameService {

  private final GameRepository gameRepository;
  private final SuccessiveVictoriesRepository successiveVictoriesRepository;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void recoding(Game game) {
    // record game
    gameRepository.save(game);

    // record successive victories
    successiveVictoriesRepository.findByCreatedDateBetweenAndPlayerUuidAndClosedSuccessive(
        WeekUtils.getLocalDateOfWeek(), LocalDate.now(), game.getPlayerUuid(), false)
      .ifPresentOrElse(findGame -> {
        if (game.getRanked()) {
          if (game.getWinning()) {
            findGame.setSummonerName(game.getSummonerName());
            findGame.setWinningCount(findGame.getWinningCount() + 1);
            findGame.setTotalKill(findGame.getTotalKill() + game.getChampionsKilled());
            findGame.setTotalDeath(findGame.getTotalKill() + game.getChampionsKilled());
            findGame.setTotalAssist(findGame.getTotalKill() + game.getChampionsKilled());
          } else {
            findGame.setClosedSuccessive(true);
            successiveVictoriesRepository.save(findGame);
          }
        }
      }, () -> {
        SuccessiveVictories successiveVictories = new SuccessiveVictories();
        successiveVictories.setPlayerUuid(game.getPlayerUuid());
        successiveVictories.setSummonerName(game.getSummonerName());
        successiveVictories.setWinningCount(1L);
        successiveVictories.setClosedSuccessive(false);
        successiveVictories.setTotalKill(game.getChampionsKilled());
        successiveVictories.setTotalDeath(game.getNumDeaths());
        successiveVictories.setTotalAssist(game.getAssists());
        successiveVictoriesRepository.save(successiveVictories);
      });
  }

  @Override
  public Page<Game> findAll(Pageable pageable) {
    return gameRepository.findAll(pageable);
  }
}
