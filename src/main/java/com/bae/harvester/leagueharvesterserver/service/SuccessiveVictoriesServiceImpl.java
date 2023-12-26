package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.WeekUtils;
import com.bae.harvester.leagueharvesterserver.entities.SuccessiveVictories;
import com.bae.harvester.leagueharvesterserver.repositories.SuccessiveVictoriesRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SuccessiveVictoriesServiceImpl implements SuccessiveVictoriesService {

  private final SuccessiveVictoriesRepository repository;

  @Override
  public List<SuccessiveVictories> findAll(LocalDate baseDate) {
    return repository.findTop10ByCreatedDateBetweenAndWinningCountGreaterThanOrderByWinningCountDesc(WeekUtils.getLocalDateOfWeek(baseDate),
      LocalDate.now(), 1L);
  }
}
