package com.bae.harvester.leagueharvesterserver;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekUtilsTest {

  @DisplayName("한주의 시작은 월요일이다.")
  @Test
  void t0() {
    for (int i = 0; i < 365 * 3; i++) {
      assertThat(WeekUtils.getLocalDateOfWeek(LocalDate.now().plusDays(i)).getDayOfWeek())
        .isEqualByComparingTo(DayOfWeek.MONDAY);
    }
  }
}