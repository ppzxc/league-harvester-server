package com.bae.harvester.server.dto.eog;

import lombok.Data;

@Data
public class MucJwtDto {

  public String channelClaim;
  public String domain;
  public String jwt;
  public String targetRegion;
}
