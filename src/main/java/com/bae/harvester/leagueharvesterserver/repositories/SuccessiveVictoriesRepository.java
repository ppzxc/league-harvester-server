package com.bae.harvester.leagueharvesterserver.repositories;

import com.bae.harvester.leagueharvesterserver.entities.SuccessiveVictories;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessiveVictoriesRepository extends JpaRepository<SuccessiveVictories, Long> {

  Optional<SuccessiveVictories> findByCreatedDateBetweenAndPlayerUuidAndClosedSuccessive(LocalDate start, LocalDate end,
    UUID playerUuid, boolean closedSuccessive);

  List<SuccessiveVictories> findTop10ByCreatedDateBetweenOrderByWinningCountDesc(LocalDate start, LocalDate end);
  List<SuccessiveVictories> findTop10ByCreatedDateBetweenAndWinningCountGreaterThanOrderByWinningCountDesc(LocalDate start, LocalDate end, Long winningCount);
}
