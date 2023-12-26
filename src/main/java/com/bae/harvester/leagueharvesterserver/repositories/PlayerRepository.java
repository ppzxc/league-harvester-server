package com.bae.harvester.leagueharvesterserver.repositories;

import com.bae.harvester.leagueharvesterserver.entities.Player;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  Optional<Player> findByPlayerUuid(UUID playerUuid);
}
