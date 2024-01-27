package com.bae.harvester.server.dto.eog;

import java.util.ArrayList;
import java.util.UUID;
import lombok.Data;

@Data
public class LocalPlayer {

  public boolean botPlayer;
  public long championId;
  public String championName;
  public String championSquarePortraitPath;
  public String detectedTeamPosition;
  public long gameId;
  public boolean isLocalPlayer;
  public ArrayList<Integer> items;
  public boolean leaver;
  public long leaves;
  public long level;
  public long losses;
  public long profileIconId;
  public UUID puuid;
  public String selectedPosition;
  public ArrayList<Object> skinEmblemPaths;
  public String skinSplashPath;
  public String skinTilePath;
  public long spell1Id;
  public long spell2Id;
  public Stats stats;
  public long summonerId;
  public String summonerName;
  public long teamId;
  public long wins;
}
