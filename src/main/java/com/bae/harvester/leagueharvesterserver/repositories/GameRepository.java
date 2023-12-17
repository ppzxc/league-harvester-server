package com.bae.harvester.leagueharvesterserver.repositories;

import com.bae.harvester.leagueharvesterserver.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
