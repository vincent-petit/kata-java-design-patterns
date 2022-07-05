package org.jkdp.state;

import static org.jkdp.forbidden.PlayerName.DJOKOVIC;
import static org.jkdp.forbidden.PlayerName.NADAL;

import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;

public class DeuceState implements SetState {

  @Override
  public void handleBallScored(PlayerName playerName, Set set) {
    if (set.getAdvantage() == null) {
      set.setAdvantage(playerName);
    } else {
      if (playerName == set.getAdvantage()) {
        set.setVictory(playerName);
      } else {
        set.setAdvantage(null);
      }
    }
  }

  public String score(Set set) {
    if (set.getAdvantage() == null) {
      return "DEUCE";
    }
    return set.getVictory() != null ?
            set.getVictory().name() + " WON" :
            NADAL.name() + " " + set.getScore().get(NADAL).getValue() + advantage(set, NADAL) + " / " + DJOKOVIC.name() + " " + set.getScore()
                    .get(DJOKOVIC)
                    .getValue() + advantage(set, DJOKOVIC);
  }

  private String advantage(Set set, PlayerName playerName) {
    if (set.getAdvantage() == playerName) {
      return " (A)";
    } else {
      return "";
    }
  }
}
