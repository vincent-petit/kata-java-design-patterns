package org.jkdp.state;

import org.jkdp.forbidden.PlayerName;

public interface SetState {
  String renderScore();
  void ballScored(PlayerName playerName);
}
