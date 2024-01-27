package com.bae.harvester.server.dto.eog;

import java.util.ArrayList;
import lombok.Data;

@Data
public class EogData{
  public long basePoints;
  public long battleBoostIpEarned;
  public long boostIpEarned;
  public long boostXpEarned;
  public boolean causedEarlySurrender;
  public long currentLevel;
  public String difficulty;
  public boolean earlySurrenderAccomplice;
  public long experienceEarned;
  public long experienceTotal;
  public long firstWinBonus;
  public boolean gameEndedInEarlySurrender;
  public long gameId;
  public long gameLength;
  public String gameMode;
  public ArrayList<String> gameMutators;
  public String gameType;
  public long globalBoostXpEarned;
  public boolean invalid;
  public long ipEarned;
  public long ipTotal;
  public boolean leveledUp;
  public LocalPlayer localPlayer;
  public long loyaltyBoostXpEarned;
  public long missionsXpEarned;
  public MucJwtDto mucJwtDto;
  public String multiUserChatId;
  public String multiUserChatPassword;
  public String myTeamStatus;
  public ArrayList<Object> newSpells;
  public long nextLevelXp;
  public long preLevelUpExperienceTotal;
  public long preLevelUpNextLevelXp;
  public long previousLevel;
  public long previousXpTotal;
  public String queueType;
  public boolean ranked;
  public long reportGameId;
  public RerollData rerollData;
  public long rpEarned;
  public TeamBoost teamBoost;
  public boolean teamEarlySurrendered;
  public ArrayList<Team> teams;
  public long timeUntilNextFirstWinBonus;
  public long xbgpBoostXpEarned;
}
