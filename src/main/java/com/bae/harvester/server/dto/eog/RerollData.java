package com.bae.harvester.server.dto.eog;

import lombok.Data;

@Data
public class RerollData {

  public long pointChangeFromChampionsOwned;
  public long pointChangeFromGameplay;
  public long pointsUntilNextReroll;
  public long pointsUsed;
  public long previousPoints;
  public long rerollCount;
  public long totalPoints;
}
