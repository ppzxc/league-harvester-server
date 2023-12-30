package com.bae.harvester.leagueharvesterserver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

public class WeekUtils {

  public static LocalDate getLocalDateOfWeek() {
    return getLocalDateOfWeek(LocalDate.now());
  }

  public static LocalDate getLocalDateOfWeek(LocalDate today) {
    return today.minusDays(today.get(ChronoField.DAY_OF_WEEK) - 1);
  }

  public static WeekSequence getCurrentWeekOfMonth(LocalDate localDate) {
    // 한 주의 시작은 월요일이고, 첫 주에 4일이 포함되어있어야 첫 주 취급 (목/금/토/일)
    WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 4);

    int weekOfMonth = localDate.get(weekFields.weekOfMonth());

    // 첫 주에 해당하지 않는 주의 경우 전 달 마지막 주차로 계산
    if (weekOfMonth == 0) {
      // 전 달의 마지막 날 기준
      LocalDate lastDayOfLastMonth = localDate.with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
      return getCurrentWeekOfMonth(lastDayOfLastMonth);
    }

    // 이번 달의 마지막 날 기준
    LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
    // 마지막 주차의 경우 마지막 날이 월~수 사이이면 다음달 1주차로 계산
    if (weekOfMonth == lastDayOfMonth.get(weekFields.weekOfMonth())
      && lastDayOfMonth.getDayOfWeek().compareTo(DayOfWeek.THURSDAY) < 0) {
      LocalDate firstDayOfNextMonth = lastDayOfMonth.plusDays(1); // 마지막 날 + 1일 => 다음달 1일
      return getCurrentWeekOfMonth(firstDayOfNextMonth);
    }

    return new WeekSequence(localDate.getMonthValue(), localDate.with(weekFields.dayOfWeek(), DayOfWeek.MONDAY.getValue()), localDate.with(weekFields.dayOfWeek(), DayOfWeek.SUNDAY.getValue()), weekOfMonth);
  }

  public record WeekSequence(int month, LocalDate startOfWeek, LocalDate endOfWeek, int sequenceOfMonth) {

    @Override
    public String toString() {
      return "%d월 %d주차".formatted(month, sequenceOfMonth);
    }
  }
}
