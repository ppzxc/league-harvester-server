package com.bae.harvester.leagueharvesterserver.service;

import com.bae.harvester.leagueharvesterserver.entities.SuccessiveVictories;
import java.time.LocalDate;
import java.util.List;

public interface SuccessiveVictoriesService {

  List<SuccessiveVictories> findAll(LocalDate baseDate);
}
