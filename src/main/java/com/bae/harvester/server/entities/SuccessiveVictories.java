package com.bae.harvester.server.entities;

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
@Table(name = "successive_victories", indexes = {
  @Index(name = "idx_created_date_and_player_uuid", columnList = "created_date, player_uuid"),
})
public class SuccessiveVictories extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @JdbcTypeCode(SqlTypes.BIGINT)
  private Long id;

  @Column(name = "player_uuid", nullable = false)
  private UUID playerUuid;

  @Column(name = "summoner_name", nullable = false)
  private String summonerName;

  @Column(name = "winning_count", nullable = false)
  private Long winningCount;

  @Column(name = "closed_successive", nullable = false)
  private Boolean closedSuccessive;

  @Column(name = "total_kill", nullable = false)
  private Long totalKill;

  @Column(name = "total_death", nullable = false)
  private Long totalDeath;

  @Column(name = "total_assist", nullable = false)
  private Long totalAssist;
}
