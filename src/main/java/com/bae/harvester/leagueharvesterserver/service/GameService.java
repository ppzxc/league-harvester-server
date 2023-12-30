package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.dto.Weeks;
import com.bae.harvester.leagueharvesterserver.entities.Game;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GameService {

  void recoding(Game game);

  Page<Game> findAll(Pageable pageable);

  List<Weeks> findWeeks();

  List<Weeks> findWeeks(LocalDate localDate);
}
