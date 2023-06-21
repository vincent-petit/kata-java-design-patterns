package org.jkdp;

import org.jkdp.forbidden.PlayerName;
import org.jkdp.forbidden.Points;

public class PlayerScore {
  public final PlayerName name;
  public Points points;

  public PlayerScore(PlayerName name) {
    this(name, Points.LOVE);
  }
  public PlayerScore(PlayerName name, Points points) {
    this.name = name;
    this.points = points;
  }
  public boolean matchPlayer(PlayerName playerName) {
    return name == playerName;
  }
}
