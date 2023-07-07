package org.jkdp;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jkdp.forbidden.PlayerName;

public class Set {

  private Map<PlayerName, PlayerScore> playersScoreMap;
  private PlayerName lastPlayerScored;
  private SetState setState;

  public Set() {
    this.playersScoreMap = new LinkedHashMap<>();
    this.playersScoreMap.put(PlayerName.NADAL, new PlayerScore());
    this.playersScoreMap.put(PlayerName.DJOKOVIC, new PlayerScore());
    this.setState = new NewSetState(this);
  }
  String ballScored(PlayerName playerName) {
    this.playersScoreMap.compute(playerName, (pn, actualState) -> actualState.updateScore());
    this.lastPlayerScored = playerName;
    updateState();
    return setState.renderScore();
  }

  private void updateState() {
      this.setState = this.setState.nextState();
  }

  public Map<PlayerName, PlayerScore> getPlayerScore() {
    return this.playersScoreMap;
  }

  public PlayerName getLastPlayerScored() {
    return lastPlayerScored;
  }
}
