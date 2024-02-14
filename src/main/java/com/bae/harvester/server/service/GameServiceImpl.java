package com.bae.harvester.server.service;

import com.bae.harvester.server.component.WeekCalculator;
import com.bae.harvester.server.component.WeekSequence;
import com.bae.harvester.server.dto.Weeks;
import com.bae.harvester.server.entities.Game;
import com.bae.harvester.server.entities.SuccessiveVictories;
import com.bae.harvester.server.repositories.GameRepository;
import com.bae.harvester.server.repositories.SuccessiveVictoriesRepository;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
  private final WeekCalculator weekCalculator;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void recoding(Game game) {
    // record game
    gameRepository.save(game);

    // record successive victories
    successiveVictoriesRepository.findByCreatedDateBetweenAndPlayerUuidAndClosedSuccessive(
        weekCalculator.getCurrentWeekOfMonth(LocalDate.now()).startOfWeek(), LocalDate.now(), game.getPlayerUuid(), false)
      .ifPresentOrElse(findGame -> {
        if (game.getRanked()) {
          if (game.getWinning()) {
            findGame.setSummonerName(game.getSummonerName());
            findGame.setWinningCount(findGame.getWinningCount() + 1);
            findGame.setTotalKill(findGame.getTotalKill() + game.getChampionsKilled());
            findGame.setTotalDeath(findGame.getTotalKill() + game.getChampionsKilled());
            findGame.setTotalAssist(findGame.getTotalKill() + game.getChampionsKilled());
            findGame.setTotalAssist(findGame.getTotalKill() + game.getChampionsKilled());
            findGame.setProfileIconId(game.getProfileIconId());
          } else {
            findGame.setClosedSuccessive(true);
            findGame.setProfileIconId(game.getProfileIconId());
            successiveVictoriesRepository.save(findGame);
          }
        }
      }, () -> {
        SuccessiveVictories successiveVictories = new SuccessiveVictories();
        successiveVictories.setPlayerUuid(game.getPlayerUuid());
        successiveVictories.setProfileIconId(game.getProfileIconId());
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

  @Override
  public List<Weeks> findWeeks() {
    Optional<Game> first = gameRepository.findFirstByOrderByCreatedDateDesc();
    if (first.isPresent()) {
      return findWeeks(first.get().getCreatedDate());
    } else {
      return List.of();
    }
  }

  @Override
  public List<Weeks> findWeeks(LocalDate localDate) {
    LocalDate now = LocalDate.now();
    if (localDate.equals(now)) {
      WeekSequence weekSequence = weekCalculator.getCurrentWeekOfMonth(now);
      return List.of(Weeks.builder()
        .month(weekSequence.month())
        .startOfWeek(weekSequence.startOfWeek())
        .endOfWeek(weekSequence.endOfWeek())
        .sequenceOfMonth(weekSequence.sequenceOfMonth())
        .build());
    } else if (localDate.isAfter(now)) {
      return List.of();
    } else {
      LocalDate baseDate = localDate;
      Map<String, Weeks> results = new HashMap<>();
      while (!baseDate.equals(now)) {
        baseDate = baseDate.plusDays(1);
        WeekSequence weekSequence = weekCalculator.getCurrentWeekOfMonth(baseDate);
        String key = "%d%d".formatted(weekSequence.month(), weekSequence.sequenceOfMonth());
        if (!results.containsKey(key)) {
          results.put(key, Weeks.builder()
            .month(weekSequence.month())
            .startOfWeek(weekSequence.startOfWeek())
            .endOfWeek(weekSequence.endOfWeek())
            .sequenceOfMonth(weekSequence.sequenceOfMonth())
            .build());
        }
      }
      return results.values().stream().sorted((o1, o2) -> {
        if (o1.month() > o2.month()) {
          return 1;
        } else if (o1.month() == o2.month()) {
          return Integer.compare(o1.sequenceOfMonth(), o2.sequenceOfMonth());
        } else {
          return -1;
        }
      }).toList();
    }
  }
}
