package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.WeekUtils;
import com.bae.harvester.leagueharvesterserver.WeekUtils.WeekSequence;
import com.bae.harvester.leagueharvesterserver.dto.Weeks;
import com.bae.harvester.leagueharvesterserver.entities.Game;
import com.bae.harvester.leagueharvesterserver.entities.SuccessiveVictories;
import com.bae.harvester.leagueharvesterserver.repositories.GameRepository;
import com.bae.harvester.leagueharvesterserver.repositories.SuccessiveVictoriesRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
      WeekSequence weekSequence = WeekUtils.getCurrentWeekOfMonth(now);
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
        WeekSequence weekSequence = WeekUtils.getCurrentWeekOfMonth(baseDate);
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
