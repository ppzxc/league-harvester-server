package com.bae.harvester.server.component;

import java.time.LocalDate;

public record WeekSequence(int month, LocalDate startOfWeek, LocalDate endOfWeek, int sequenceOfMonth) {

  @Override
  public String toString() {
    return "%d월 %d주차".formatted(month, sequenceOfMonth);
  }
}