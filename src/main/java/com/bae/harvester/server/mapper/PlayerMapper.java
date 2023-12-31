package com.bae.harvester.server.mapper;

import com.bae.harvester.server.dto.EndOfGameBlockDto;
import com.bae.harvester.server.entities.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

  @Mappings(value = {
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createdDate", ignore = true),
    @Mapping(target = "createdDateTime", ignore = true),
    @Mapping(target = "lastModifiedDate", ignore = true),
    @Mapping(target = "playerUuid", source = "puuid"),
  })
  Player of(EndOfGameBlockDto endOfGameBlockDto);
}
