package org.jkdp;

import java.util.stream.Collectors;
import org.jkdp.forbidden.Points;

public class NewSetState implements SetState {

  private final Set set;

  public NewSetState(Set set) {
    this.set = set;
  }

  @Override
  public SetState nextState() {
    if (set.getPlayerScore().values().stream().anyMatch(v -> v.getCurrentScore() != Points.LOVE)) {
      return new InProgressSetState(this.set);

    } else {

      return this;
    }
  }

  @Override
  public String renderScore() {
    return this.set.getPlayerScore().entrySet()
            .stream().map(e -> e.getKey().name() + " 0")
            .collect(Collectors.joining(" / "));
  }
}
