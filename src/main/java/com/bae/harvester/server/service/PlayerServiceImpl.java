package com.bae.harvester.server.service;

import com.bae.harvester.server.entities.Player;
import com.bae.harvester.server.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository playerRepository;

  @Transactional
  @Override
  public void recoding(Player player) {
    playerRepository.findByPlayerUuid(player.getPlayerUuid()).ifPresentOrElse(findPlayer -> {
      if (!findPlayer.getSummonerName().equals(player.getSummonerName())) {
        findPlayer.setSummonerName(player.getSummonerName());
        playerRepository.save(findPlayer);
      }
    }, () -> playerRepository.save(player));
  }
}
