package com.bae.harvester.server.dto.eog;

import lombok.Data;

@Data
public class EndOfGameBlockOriginalDto {

  private EogData data;
  private String eventType;
  private String uri;
}

