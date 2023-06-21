package org.jkdp.state;

import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;

public class WonSetState implements SetState {
  Set setContext;

  public WonSetState(Set setContext, PlayerName playerName) {
    this.setContext = setContext;
    setContext.setWinner(playerName);
  }

  @Override
  public String renderScore() {
    return setContext.getWinner() + " WON";
  }

  @Override
  public void ballScored(PlayerName playerName) {
    throw new IllegalStateException("Cannot score when the party is won");
  }
}
