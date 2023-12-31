package com.bae.harvester.server.service;

import com.bae.harvester.server.component.WeekCalculator;
import com.bae.harvester.server.entities.SuccessiveVictories;
import com.bae.harvester.server.repositories.SuccessiveVictoriesRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SuccessiveVictoriesServiceImpl implements SuccessiveVictoriesService {

  private final SuccessiveVictoriesRepository repository;
  private final WeekCalculator weekCalculator;

  @Override
  public List<SuccessiveVictories> findAll(LocalDate baseDate) {
    return repository.findAllSuccessive(weekCalculator.getCurrentWeekOfMonth(baseDate).startOfWeek(), LocalDate.now());
  }
}
