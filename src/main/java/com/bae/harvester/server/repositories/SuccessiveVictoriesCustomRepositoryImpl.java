package com.bae.harvester.server.repositories;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class SuccessiveVictoriesCustomRepositoryImpl implements SuccessiveVictoriesCustomRepository {

  private final JPAQueryFactory query;
}
