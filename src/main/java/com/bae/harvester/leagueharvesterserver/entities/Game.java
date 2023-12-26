package com.bae.harvester.leagueharvesterserver.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@ToString
@Entity
@Table(name = "games", indexes = {
  @Index(name = "idx_created_date", columnList = "created_date"),
})
public class Game extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @JdbcTypeCode(SqlTypes.BIGINT)
  private Long id;

  @Column(name = "player_uuid", nullable = false)
  private UUID playerUuid;

  @Column(name = "summoner_id", nullable = false)
  private Long summonerId;

  @Column(name = "summoner_name", nullable = false)
  private String summonerName;

  @Column(name = "game_id")
  private String gameId;

  @Column(name = "report_game_id")
  private String reportGameId;

  @Column(name = "game_mode", nullable = false)
  private String gameMode;

  @Column(name = "game_type", nullable = false)
  private String gameType;

  @Column(name = "detected_team_position")
  private String detectedTeamPosition;

  @Column(name = "selected_position")
  private String selectedPosition;

  @Column(name = "queue_type")
  private String queueType;

  @Column(name = "ranked", nullable = false)
  private Boolean ranked;

  @Column(name = "champion_id")
  private Long championId;

  @Column(name = "champion_name")
  private String championName;

  @Column(name = "spell_1_id")
  private String spell1Id;

  @Column(name = "spell_2_id")
  private String spell2Id;

  @Column(name = "leaver")
  private Boolean leaver;

  @Column(name = "bot_player")
  private Boolean botPlayer;

  @Column(name = "local_player")
  private Boolean localPlayer;

  @Column(name = "winning", nullable = false)
  private Boolean winning;

  @Column(name = "champions_killed", nullable = false)
  private Long championsKilled;

  @Column(name = "assists", nullable = false)
  private Long assists;

  @Column(name = "num_deaths", nullable = false)
  private Long numDeaths;

  @Column(name = "barracks_killed")
  private Long barracksKilled;

  @Column(name = "game_ended_in_early_surrender")
  private Long gameEndedInEarlySurrender;

  @Column(name = "game_ended_in_surrender")
  private Long gameEndedInSurrender;

  @Column(name = "gold_earned")
  private Long goldEarned;

  @Column(name = "total_damage_dealt")
  private Long totalDamageDealt;

  @Column(name = "total_damage_dealt_to_buildings")
  private Long totalDamageDealtToBuildings;

  @Column(name = "total_damage_dealt_to_champions")
  private Long totalDamageDealtToChampions;

  @Column(name = "total_damage_dealt_to_objectives")
  private Long totalDamageDealtToObjectives;

  @Column(name = "total_damage_dealt_to_turrets")
  private Long totalDamageDealtToTurrets;

  @Column(name = "total_damage_taken")
  private Long totalDamageTaken;
}
