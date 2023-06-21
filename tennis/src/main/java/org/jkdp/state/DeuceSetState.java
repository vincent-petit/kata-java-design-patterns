package org.jkdp.state;

import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;

public class DeuceSetState implements SetState {
  Set setContext;

  public DeuceSetState(Set setContext) {
    this.setContext = setContext;
    this.setContext.setAdvantagePlayer(null);
  }

  @Override
  public String renderScore() {
    return "DEUCE";
  }

  @Override
  public void ballScored(PlayerName playerName) {
    setContext.changeState(new AdvantageSetState(setContext, playerName));
  }
}
