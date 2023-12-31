package com.bae.harvester.server.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Builder;

@Builder
public record EndOfGameBlockDto(
  Long gameId,
  Long reportGameId,
  @NotNull
  String gameMode,
  @NotNull
  String gameType,
  String detectedTeamPosition,
  String selectedPosition,
  String queueType,
  @NotNull
  Boolean ranked,
  Long championId,
  String championName,
  Long spell1Id,
  Long spell2Id,
  Boolean leaver,
  @Valid
  @NotNull
  Stats stats,
  @NotNull
  UUID puuid,
  @NotNull
  Long summonerId,
  @NotNull
  String summonerName,
  Boolean botPlayer,
  Boolean localPlayer,
  @NotNull
  Boolean winning
) {

  @Builder
  public record Stats(
    @NotNull
    Long assists,
    Long barracksKilled,
    @NotNull
    Long championsKilled,
    Long gameEndedInEarlySurrender,
    Long gameEndedInSurrender,
    Long goldEarned,
    @NotNull
    Long numDeaths,
    Long totalDamageDealt,
    Long totalDamageDealtToBuildings,
    Long totalDamageDealtToChampions,
    Long totalDamageDealtToObjectives,
    Long totalDamageDealtToTurrets,
    Long totalDamageTaken
  ) {

  }
}
