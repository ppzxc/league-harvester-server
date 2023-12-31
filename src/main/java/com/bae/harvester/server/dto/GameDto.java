package com.bae.harvester.server.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
public record GameDto(
  Long id,
  UUID playerUuid,
  Long summonerId,
  String summonerName,
  String gameId,
  String reportGameId,
  String gameMode,
  String gameType,
  String detectedTeamPosition,
  String selectedPosition,
  String queueType,
  Boolean ranked,
  Long championId,
  String championName,
  String spell1Id,
  String spell2Id,
  Boolean leaver,
  Boolean botPlayer,
  Boolean localPlayer,
  Boolean winning,
  Long championsKilled,
  Long assists,
  Long numDeaths,
  Long barracksKilled,
  Long gameEndedInEarlySurrender,
  Long gameEndedInSurrender,
  Long goldEarned,
  Long totalDamageDealt,
  Long totalDamageDealtToBuildings,
  Long totalDamageDealtToChampions,
  Long totalDamageDealtToObjectives,
  Long totalDamageDealtToTurrets,
  Long totalDamageTaken,
  LocalDateTime createdDate,
  LocalDateTime lastModifiedDate
) {

}
