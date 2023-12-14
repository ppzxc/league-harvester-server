package com.bae.harvester.leagueharvesterserver.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.BuilderArbitraryIntrospector;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("EOG Record Test")
class EndOfGameBlockTest {

  @Test
  void t0() throws JsonProcessingException {
    FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
      .objectIntrospector(BuilderArbitraryIntrospector.INSTANCE)
      .plugin(new JakartaValidationPlugin())
      .build();

    System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter()
      .writeValueAsString(fixtureMonkey.giveMeOne(EndOfGameBlock.class)));
  }
}