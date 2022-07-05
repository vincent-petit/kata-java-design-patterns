package org.jkdp;

import static org.jkdp.forbidden.PlayerName.DJOKOVIC;
import static org.jkdp.forbidden.PlayerName.NADAL;
import static org.jkdp.forbidden.Points.LOVE;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.jkdp.forbidden.PlayerName;
import org.jkdp.forbidden.Points;
import org.jkdp.state.SetState;
import org.jkdp.state.StandardState;

@Setter
@Getter
public class Set {

  private SetState state = new StandardState();

  private Map<PlayerName, Points> score = new HashMap<>();

  private PlayerName advantage = null;
  private PlayerName victory = null;

  public Set() {
    score.put(NADAL, LOVE);
    score.put(DJOKOVIC, LOVE);
  }

  String ballScored(PlayerName playerName) {
    state.handleBallScored(playerName, this);
    return state.score(this);
  }

}
