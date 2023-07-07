package org.jkdp;

import org.jkdp.forbidden.Points;

public class PlayerScore {

  private Points currentScore = Points.LOVE;

  public PlayerScore updateScore() {
    Points newPoints = null;
    switch (currentScore) {
      case LOVE:
        newPoints = Points.FIFTEEN;
        break;
      case FIFTEEN:
        newPoints = Points.THIRTY;
        break;
      case THIRTY:
        newPoints = Points.FOURTY;
        break;
      case FOURTY:
        break;

      default:
        throw new IllegalStateException("Unexpected value: " + currentScore);
    }
    currentScore = newPoints;
    return this;
  }

  public Points getCurrentScore() {
    return this.currentScore;
  }
}
