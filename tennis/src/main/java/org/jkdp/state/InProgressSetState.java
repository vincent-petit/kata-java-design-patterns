package org.jkdp.state;

import org.jkdp.PlayerScore;
import org.jkdp.Set;
import org.jkdp.forbidden.PlayerName;
import org.jkdp.forbidden.Points;

public class InProgressSetState implements SetState {
  Set setContext;

  public InProgressSetState(Set setContext) {
    this.setContext = setContext;
  }

  @Override
  public String renderScore() {
    PlayerScore player1Score = setContext.getPlayer1Score();
    PlayerScore player2Score = setContext.getPlayer2Score();
    return player1Score.name + " " + player1Score.points.getValue() + " / "
            + player2Score.name + " " + player2Score.points.getValue();
  }

  @Override
  public void ballScored(PlayerName playerName) {
    PlayerScore playerScore = setContext.getPlayerScore(playerName);
    switch (playerScore.points) {
      case LOVE:
        playerScore.points = Points.FIFTEEN;
        break;
      case FIFTEEN:
        playerScore.points = Points.THIRTY;
        break;
      case THIRTY:
        playerScore.points = Points.FOURTY;
        //TODO
        break;
      case FOURTY:
        //TODO
        break;
    }
  }
}
