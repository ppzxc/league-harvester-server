package com.bae.harvester.server.component;

import java.time.LocalDate;

public interface WeekCalculator {

  WeekSequence getCurrentWeekOfMonth(LocalDate baseDate);
}
