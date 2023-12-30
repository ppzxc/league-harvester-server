package com.bae.harvester.leagueharvesterserver.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record Weeks(
  int month,
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  LocalDate startOfWeek,
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  LocalDate endOfWeek,
  int sequenceOfMonth
) {

}
