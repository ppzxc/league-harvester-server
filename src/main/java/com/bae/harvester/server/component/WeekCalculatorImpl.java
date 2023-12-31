package com.bae.harvester.server.component;

import com.bae.harvester.server.properties.WeekProperties;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WeekCalculatorImpl implements WeekCalculator {

  private final WeekProperties weekProperties;

  @Override
  public WeekSequence getCurrentWeekOfMonth(LocalDate baseDate) {
    // 한 주의 시작은 월요일이고, 첫 주에 4일이 포함되어있어야 첫 주 취급 (목/금/토/일)
    WeekFields weekFields = WeekFields.of(weekProperties.getBaseDayOfWeek(), weekProperties.getBaseWeek());

    int weekOfMonth = baseDate.get(weekFields.weekOfMonth());

    // 첫 주에 해당하지 않는 주의 경우 전 달 마지막 주차로 계산
    if (weekOfMonth == 0) {
      // 전 달의 마지막 날 기준
      LocalDate lastDayOfLastMonth = baseDate.with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
      return getCurrentWeekOfMonth(lastDayOfLastMonth);
    }

    // 이번 달의 마지막 날 기준
    LocalDate lastDayOfMonth = baseDate.with(TemporalAdjusters.lastDayOfMonth());
    // 마지막 주차의 경우 마지막 날이 월~수 사이이면 다음달 1주차로 계산
    if (weekOfMonth == lastDayOfMonth.get(weekFields.weekOfMonth())
      && lastDayOfMonth.getDayOfWeek().compareTo(DayOfWeek.THURSDAY) < 0) {
      LocalDate firstDayOfNextMonth = lastDayOfMonth.plusDays(1); // 마지막 날 + 1일 => 다음달 1일
      return getCurrentWeekOfMonth(firstDayOfNextMonth);
    }

    return new WeekSequence(baseDate.getMonthValue(),
      baseDate.with(weekFields.dayOfWeek(), DayOfWeek.MONDAY.getValue()),
      baseDate.with(weekFields.dayOfWeek(), DayOfWeek.SUNDAY.getValue()), weekOfMonth);
  }
}
