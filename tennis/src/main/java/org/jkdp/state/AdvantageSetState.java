package org.jkdp.state;

import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;

public class AdvantageSetState implements SetState {
  Set setContext;

  public AdvantageSetState(Set setContext, PlayerName playerName) {
    this.setContext = setContext;
    setContext.setAdvantagePlayer(playerName);
  }

  @Override
  public String renderScore() {
    return "TODO";
  }

  @Override
  public void ballScored(PlayerName playerName) {
    PlayerName advantagePlayer = setContext.getAdvantagePlayer();
    if (advantagePlayer.equals(playerName)) {
      setContext.changeState(new WonSetState(setContext, playerName));
      return;
    }
    setContext.changeState(new DeuceSetState(setContext));

  }
}
