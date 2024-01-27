package com.bae.harvester.server;

import com.bae.harvester.server.component.WeekCalculator;
import com.bae.harvester.server.mapper.GameMapper;
import com.bae.harvester.server.service.GameService;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@AllArgsConstructor
@EnableJpaAuditing
@SpringBootApplication
public class LeagueHarvesterServerApplication implements CommandLineRunner {

  private final GameService gameService;
  private final GameMapper gameMapper;
  private final WeekCalculator weekCalculator;

  public static void main(String[] args) {
    SpringApplication.run(LeagueHarvesterServerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    for (int i = 30; i >= 0; i--) {
      LocalDate baseDate = LocalDate.now().minusDays(i);
      log.info("{} {} - {} ", baseDate, baseDate.getDayOfWeek(), weekCalculator.getCurrentWeekOfMonth(baseDate));
    }
  }
}
