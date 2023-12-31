package com.bae.harvester.server;

import static org.assertj.core.api.Assertions.assertThat;

import com.bae.harvester.server.component.WeekCalculator;
import com.bae.harvester.server.component.WeekCalculatorImpl;
import com.bae.harvester.server.properties.WeekProperties;
import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekUtilsTest {

  private WeekCalculator weekCalculator = new WeekCalculatorImpl(new WeekProperties());

  @DisplayName("한주의 시작은 월요일이다.")
  @Test
  void t0() {
    for (int i = 0; i < 365 * 3; i++) {
      assertThat(weekCalculator.getCurrentWeekOfMonth(LocalDate.now().plusDays(i)).startOfWeek().getDayOfWeek())
        .isEqualByComparingTo(DayOfWeek.WEDNESDAY);
    }
  }
}