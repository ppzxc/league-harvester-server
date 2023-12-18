package com.bae.harvester.leagueharvesterserver;

import com.bae.harvester.leagueharvesterserver.mapper.GameMapper;
import com.bae.harvester.leagueharvesterserver.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class LeagueHarvesterServerApplication implements CommandLineRunner {

  private final GameService gameService;
  private final GameMapper gameMapper;

  public static void main(String[] args) {
    SpringApplication.run(LeagueHarvesterServerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//		FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
//			.objectIntrospector(new BuilderArbitraryIntrospector())
//			.plugin(new JakartaValidationPlugin())
//			.build();
//
//		fixtureMonkey.giveMe(EndOfGameBlock.class, 50).stream().map(gameMapper::of).forEach(gameService::record);
  }
}
