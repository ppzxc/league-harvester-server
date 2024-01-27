package com.bae.harvester.server.dto.eog;

import java.util.ArrayList;
import lombok.Data;

@Data
public class TeamBoost {

  public ArrayList<Object> availableSkins;
  public long ipReward;
  public long ipRewardForPurchaser;
  public long price;
  public String skinUnlockMode;
  public String summonerName;
  public boolean unlocked;
}
