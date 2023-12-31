package com.bae.harvester.server.mapper;

import com.bae.harvester.server.dto.SuccessiveVictoriesDto;
import com.bae.harvester.server.entities.SuccessiveVictories;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SuccessiveVictoriesMapper {

  List<SuccessiveVictoriesDto> of(List<SuccessiveVictories> successiveVictories);
}
