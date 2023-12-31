package com.bae.harvester.server.dto;

import java.util.UUID;

public record SuccessiveVictoriesDto(
  Long id,
  UUID playerUuid,
  String summonerName,
  Long winningCount,
  Long totalKill,
  Long totalDeath,
  Long totalAssist) {

}
