package com.bae.harvester.server.service;

import com.bae.harvester.server.entities.SuccessiveVictories;
import java.time.LocalDate;
import java.util.List;

public interface SuccessiveVictoriesService {

  List<SuccessiveVictories> findAll(LocalDate baseDate);
}