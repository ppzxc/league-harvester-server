package com.bae.harvester.server.mapper;

import com.bae.harvester.server.dto.EndOfGameBlockDto;
import com.bae.harvester.server.dto.EndOfGameBlockDto.Stats;
import com.bae.harvester.server.dto.GameDto;
import com.bae.harvester.server.dto.eog.EndOfGameBlockOriginalDto;
import com.bae.harvester.server.dto.eog.Team;
import com.bae.harvester.server.entities.Game;
import java.util.Arrays;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GameMapper {

  @Mappings({
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "playerUuid", source = "puuid"),
    @Mapping(target = "championsKilled", source = "stats.championsKilled"),
    @Mapping(target = "assists", source = "stats.assists"),
    @Mapping(target = "numDeaths", source = "stats.numDeaths"),
    @Mapping(target = "barracksKilled", source = "stats.barracksKilled"),
    @Mapping(target = "gameEndedInEarlySurrender", source = "stats.gameEndedInEarlySurrender"),
    @Mapping(target = "gameEndedInSurrender", source = "stats.gameEndedInSurrender"),
    @Mapping(target = "goldEarned", source = "stats.goldEarned"),
    @Mapping(target = "totalDamageDealt", source = "stats.totalDamageDealt"),
    @Mapping(target = "totalDamageDealtToBuildings", source = "stats.totalDamageDealtToBuildings"),
    @Mapping(target = "totalDamageDealtToChampions", source = "stats.totalDamageDealtToChampions"),
    @Mapping(target = "totalDamageDealtToObjectives", source = "stats.totalDamageDealtToObjectives"),
    @Mapping(target = "totalDamageDealtToTurrets", source = "stats.totalDamageDealtToTurrets"),
    @Mapping(target = "totalDamageTaken", source = "stats.totalDamageTaken"),
    @Mapping(target = "profileIconId", source = "profileIconId"),
  })
  Game of(EndOfGameBlockDto endOfGameBlockDto);

  GameDto of(Game game);

  default EndOfGameBlockDto of(EndOfGameBlockOriginalDto endOfGameBlockOriginalDto) {
    return EndOfGameBlockDto.builder()
      .gameId(endOfGameBlockOriginalDto.getData().getGameId())
      .reportGameId(endOfGameBlockOriginalDto.getData().getReportGameId())
      .profileIconId(endOfGameBlockOriginalDto.getData().getLocalPlayer().profileIconId)
      .gameMode(endOfGameBlockOriginalDto.getData().getGameMode())
      .gameType(endOfGameBlockOriginalDto.getData().getGameType())
      .detectedTeamPosition(endOfGameBlockOriginalDto.getData().getLocalPlayer().getDetectedTeamPosition())
      .selectedPosition(endOfGameBlockOriginalDto.getData().getLocalPlayer().getSelectedPosition())
      .queueType(endOfGameBlockOriginalDto.getData().getQueueType())
      .ranked(endOfGameBlockOriginalDto.getData().isRanked())
      .championId(endOfGameBlockOriginalDto.getData().getLocalPlayer().getChampionId())
      .championName(endOfGameBlockOriginalDto.getData().getLocalPlayer().getChampionName())
      .spell1Id(endOfGameBlockOriginalDto.getData().getLocalPlayer().getSpell1Id())
      .spell2Id(endOfGameBlockOriginalDto.getData().getLocalPlayer().getSpell2Id())
      .leaver(endOfGameBlockOriginalDto.getData().getLocalPlayer().isLeaver())
      .puuid(endOfGameBlockOriginalDto.getData().getLocalPlayer().getPuuid())
      .summonerId(endOfGameBlockOriginalDto.getData().getLocalPlayer().getSummonerId())
      .summonerName(endOfGameBlockOriginalDto.getData().getLocalPlayer().getSummonerName())
      .botPlayer(endOfGameBlockOriginalDto.getData().getLocalPlayer().isBotPlayer())
      .localPlayer(endOfGameBlockOriginalDto.getData().getLocalPlayer().isLocalPlayer())
      .winning(endOfGameBlockOriginalDto.getData().getTeams().stream()
        .filter(Team::isPlayerTeam)
        .anyMatch(Team::isWinningTeam))
      .stats(Stats.builder()
        .assists(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getAssists())
        .barracksKilled(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getBarracksKilled())
        .championsKilled(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getChampionsKilled())
        .gameEndedInEarlySurrender(
          endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getGameEndedInEarlySurrender())
        .gameEndedInSurrender(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getGameEndedInSurrender())
        .goldEarned(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getGoldEarned())
        .numDeaths(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getNumDeaths())
        .totalDamageDealt(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getTotalDamageDealt())
        .totalDamageDealtToBuildings(
          endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getTotalDamageDealtToBuildings())
        .totalDamageDealtToChampions(
          endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getTotalDamageDealtToChampions())
        .totalDamageDealtToObjectives(
          endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getTotalDamageDealtToObjectives())
        .totalDamageDealtToTurrets(
          endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getTotalDamageDealtToTurrets())
        .totalDamageTaken(endOfGameBlockOriginalDto.getData().getLocalPlayer().getStats().getTotalDamageTaken())
        .build())
      .build();
  }
}
