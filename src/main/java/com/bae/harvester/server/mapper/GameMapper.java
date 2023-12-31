package com.bae.harvester.server.mapper;

import com.bae.harvester.server.dto.EndOfGameBlockDto;
import com.bae.harvester.server.dto.GameDto;
import com.bae.harvester.server.entities.Game;
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
  })
  Game of(EndOfGameBlockDto endOfGameBlockDto);

  GameDto of(Game game);
}
