package org.jkdp.state;

import static org.jkdp.forbidden.PlayerName.DJOKOVIC;
import static org.jkdp.forbidden.PlayerName.NADAL;
import static org.jkdp.forbidden.Points.FIFTEEN;
import static org.jkdp.forbidden.Points.FOURTY;
import static org.jkdp.forbidden.Points.LOVE;
import static org.jkdp.forbidden.Points.THIRTY;

import java.util.Map;
import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;
import org.jkdp.forbidden.Points;

public class StandardState implements SetState {

  private static final Map<Points, Points> SCORING_PATTERN = Map.of(
          LOVE, FIFTEEN,
          FIFTEEN, THIRTY,
          THIRTY, FOURTY
  );

  @Override
  public void handleBallScored(PlayerName playerName, Set set) {
    var newScore = SCORING_PATTERN.get(set.getScore().get(playerName));
    if (newScore == null) {
      set.setVictory(playerName);
    } else {
      set.getScore().put(playerName, newScore);
    }
    if (set.getScore().values().stream().filter(points -> points == FOURTY).count() == 2) {
      set.setState(new DeuceState());
    } else {
      set.setState(new StandardState());
    }
  }

  public String score(Set set) {
    return set.getVictory() != null ?
            set.getVictory().name() + " WON" :
            NADAL.name() + " " + set.getScore().get(NADAL).getValue() + " / " + DJOKOVIC.name() + " " + set.getScore().get(DJOKOVIC).getValue();
  }
}
