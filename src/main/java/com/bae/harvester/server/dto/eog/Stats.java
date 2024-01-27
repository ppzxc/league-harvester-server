package com.bae.harvester.server.dto.eog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Stats {

  @JsonProperty("ASSISTS")
  private long assists;
  @JsonProperty("BARRACKS_KILLED")
  private long barracksKilled;
  @JsonProperty("CHAMPIONS_KILLED")
  private long championsKilled;
  @JsonProperty("GAME_ENDED_IN_EARLY_SURRENDER")
  private long gameEndedInEarlySurrender;
  @JsonProperty("GAME_ENDED_IN_SURRENDER")
  private long gameEndedInSurrender;
  @JsonProperty("GOLD_EARNED")
  private long goldEarned;
  @JsonProperty("LARGEST_CRITICAL_STRIKE")
  private long largestCriticalStrike;
  @JsonProperty("LARGEST_KILLING_SPREE")
  private long largestKillingSpree;
  @JsonProperty("LARGEST_MULTI_KILL")
  private long largestMultiKill;
  @JsonProperty("LEVEL")
  private long level;
  @JsonProperty("LOSE")
  private long lose;
  @JsonProperty("MAGIC_DAMAGE_DEALT_PLAYER")
  private long magicDamageDealtPlayer;
  @JsonProperty("MAGIC_DAMAGE_DEALT_TO_CHAMPIONS")
  private long magicDamageDealtToChampions;
  @JsonProperty("MAGIC_DAMAGE_TAKEN")
  private long magicDamageTaken;
  @JsonProperty("MINIONS_KILLED")
  private long minionsKilled;
  @JsonProperty("NEUTRAL_MINIONS_KILLED")
  private long neutralMinionsKilled;
  @JsonProperty("NUM_DEATHS")
  private long numDeaths;
  @JsonProperty("PERK0")
  private long perk0;
  @JsonProperty("PERK0_VAR1")
  private long perk0Var1;
  @JsonProperty("PERK0_VAR2")
  private long perk0Var2;
  @JsonProperty("PERK0_VAR3")
  private long perk0Var3;
  @JsonProperty("PERK1")
  private long perk1;
  @JsonProperty("PERK1_VAR1")
  private long perk1Var1;
  @JsonProperty("PERK1_VAR2")
  private long perk1Var2;
  @JsonProperty("PERK1_VAR3")
  private long perk1Var3;
  @JsonProperty("PERK2")
  private long perk2;
  @JsonProperty("PERK2_VAR1")
  private long perk2Var1;
  @JsonProperty("PERK2_VAR2")
  private long perk2Var2;
  @JsonProperty("PERK2_VAR3")
  private long perk2Var3;
  @JsonProperty("PERK3")
  private long perk3;
  @JsonProperty("PERK3_VAR1")
  private long perk3Var1;
  @JsonProperty("PERK3_VAR2")
  private long perk3Var2;
  @JsonProperty("PERK3_VAR3")
  private long perk3Var3;
  @JsonProperty("PERK4")
  private long perk4;
  @JsonProperty("PERK4_VAR1")
  private long perk4Var1;
  @JsonProperty("PERK4_VAR2")
  private long perk4Var2;
  @JsonProperty("PERK4_VAR3")
  private long perk4Var3;
  @JsonProperty("PERK5")
  private long perk5;
  @JsonProperty("PERK5_VAR1")
  private long perk5Var1;
  @JsonProperty("PERK5_VAR2")
  private long perk5Var2;
  @JsonProperty("PERK5_VAR3")
  private long perk5Var3;
  @JsonProperty("PERK_PRIMARY_STYLE")
  private long perkPrimaryStyle;
  @JsonProperty("PERK_SUB_STYLE")
  private long perkSubStyle;
  @JsonProperty("PHYSICAL_DAMAGE_DEALT_PLAYER")
  private long physicalDamageDealtPlayer;
  @JsonProperty("PHYSICAL_DAMAGE_DEALT_TO_CHAMPIONS")
  private long physicalDamageDealtToChampions;
  @JsonProperty("PHYSICAL_DAMAGE_TAKEN")
  private long physicalDamageTaken;
  @JsonProperty("PLAYER_AUGMENT_1")
  private long playerAugment1;
  @JsonProperty("PLAYER_AUGMENT_2")
  private long playerAugment2;
  @JsonProperty("PLAYER_AUGMENT_3")
  private long playerAugment3;
  @JsonProperty("PLAYER_AUGMENT_4")
  private long playerAugment4;
  @JsonProperty("PLAYER_SUBTEAM")
  private long playerSubteam;
  @JsonProperty("PLAYER_SUBTEAM_PLACEMENT")
  private long playerSubteamPlacement;
  @JsonProperty("SIGHT_WARDS_BOUGHT_IN_GAME")
  private long sightWardsBoughtInGame;
  @JsonProperty("SPELL1_CAST")
  private long spell1Cast;
  @JsonProperty("SPELL2_CAST")
  private long spell2Cast;
  @JsonProperty("TEAM_EARLY_SURRENDERED")
  private long teamEarlySurrendered;
  @JsonProperty("TEAM_OBJECTIVE")
  private long teamObjective;
  @JsonProperty("TIME_CCING_OTHERS")
  private long timeCcingOthers;
  @JsonProperty("TOTAL_DAMAGE_DEALT")
  private long totalDamageDealt;
  @JsonProperty("TOTAL_DAMAGE_DEALT_TO_BUILDINGS")
  private long totalDamageDealtToBuildings;
  @JsonProperty("TOTAL_DAMAGE_DEALT_TO_CHAMPIONS")
  private long totalDamageDealtToChampions;
  @JsonProperty("TOTAL_DAMAGE_DEALT_TO_OBJECTIVES")
  private long totalDamageDealtToObjectives;
  @JsonProperty("TOTAL_DAMAGE_DEALT_TO_TURRETS")
  private long totalDamageDealtToTurrets;
  @JsonProperty("TOTAL_DAMAGE_SELF_MITIGATED")
  private long totalDamageSelfMitigated;
  @JsonProperty("TOTAL_DAMAGE_SHIELDED_ON_TEAMMATES")
  private long totalDamageShieldedOnTeammates;
  @JsonProperty("TOTAL_DAMAGE_TAKEN")
  private long totalDamageTaken;
  @JsonProperty("TOTAL_HEAL")
  private long totalHeal;
  @JsonProperty("TOTAL_HEAL_ON_TEAMMATES")
  private long totalHealOnTeammates;
  @JsonProperty("TOTAL_TIME_CROWD_CONTROL_DEALT")
  private long totalTimeCrowdControlDealt;
  @JsonProperty("TOTAL_TIME_SPENT_DEAD")
  private long totalTimeSpentDead;
  @JsonProperty("TRUE_DAMAGE_DEALT_PLAYER")
  private long trueDamageDealtPlayer;
  @JsonProperty("TRUE_DAMAGE_DEALT_TO_CHAMPIONS")
  private long trueDamageDealtToChampions;
  @JsonProperty("TRUE_DAMAGE_TAKEN")
  private long trueDamageTaken;
  @JsonProperty("TURRETS_KILLED")
  private long turretsKilled;
  @JsonProperty("VISION_WARDS_BOUGHT_IN_GAME")
  private long visionWardsBoughtInGame;
  @JsonProperty("WAS_AFK")
  private long wasAfk;
}

