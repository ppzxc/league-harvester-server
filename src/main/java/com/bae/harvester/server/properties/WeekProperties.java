package com.bae.harvester.server.properties;

import java.time.DayOfWeek;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("harvester.week")
public class WeekProperties {

  private DayOfWeek baseDayOfWeek = DayOfWeek.WEDNESDAY;
  private int baseWeek = 4;
}
