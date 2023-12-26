package com.bae.harvester.leagueharvesterserver.mapper;

import com.bae.harvester.leagueharvesterserver.dto.SuccessiveVictoriesDto;
import com.bae.harvester.leagueharvesterserver.entities.SuccessiveVictories;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SuccessiveVictoriesMapper {

  List<SuccessiveVictoriesDto> of(List<SuccessiveVictories> successiveVictories);
}
