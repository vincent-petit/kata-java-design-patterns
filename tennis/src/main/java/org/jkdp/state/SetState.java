package org.jkdp.state;

import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;

public interface SetState {

  void handleBallScored(PlayerName playerName, Set set);

  String score(Set set);
}
