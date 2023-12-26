package com.bae.harvester.leagueharvesterserver.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "players")
public class Player extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @JdbcTypeCode(SqlTypes.BIGINT)
  private Long id;

  @Column(name = "player_uuid", nullable = false, unique = true)
  private UUID playerUuid;

  @Column(name = "summoner_id", nullable = false, unique = true)
  private Long summonerId;

  @Column(name = "summoner_name", nullable = false, unique = true)
  private String summonerName;
}
