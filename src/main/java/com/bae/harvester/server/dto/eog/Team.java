package com.bae.harvester.server.dto.eog;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Team {

  public String fullId;
  public boolean isBottomTeam;
  public boolean isPlayerTeam;
  public boolean isWinningTeam;
  public String memberStatusString;
  public String name;
  public ArrayList<Player> players;
  public String tag;
  public long teamId;
}
