package com.bae.harvester.server.repositories;

import com.bae.harvester.server.entities.Game;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  Optional<Game> findFirstByOrderByCreatedDateDesc();
}
