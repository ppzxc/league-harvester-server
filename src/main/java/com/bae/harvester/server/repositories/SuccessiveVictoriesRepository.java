package com.bae.harvester.server.repositories;

import com.bae.harvester.server.entities.SuccessiveVictories;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessiveVictoriesRepository extends JpaRepository<SuccessiveVictories, Long>,
  SuccessiveVictoriesCustomRepository {

  Optional<SuccessiveVictories> findByCreatedDateBetweenAndPlayerUuidAndClosedSuccessive(LocalDate start, LocalDate end,
    UUID playerUuid, boolean closedSuccessive);

  @Query(value = """
    SELECT *
    FROM (SELECT row_number() OVER (PARTITION BY player_uuid ORDER BY winning_count DESC) AS row_number,
                 id,
                 player_uuid,
                 profile_icon_id,
                 summoner_name,
                 winning_count,
                 closed_successive,
                 total_kill,
                 total_assist,
                 total_death,
                 created_date,
                 created_date_time,
                 last_modified_date
          FROM successive_victories
          WHERE created_date >= :start
            AND created_date <= :end
            AND winning_count > 1)
    WHERE row_number = 1
    """,
    nativeQuery = true)
  List<SuccessiveVictories> findAllSuccessive(LocalDate start, LocalDate end);
}
