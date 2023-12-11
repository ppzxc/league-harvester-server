package com.bae.harvester.leagueharvesterserver.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@ToString
@Entity(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  @JdbcTypeCode(SqlTypes.BIGINT)
  private Long id;

  @Column(name = "puuid", nullable = false)
  @JdbcTypeCode(SqlTypes.UUID)
  private UUID puuid;
}
