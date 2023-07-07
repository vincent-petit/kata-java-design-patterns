package org.jkdp;

import java.util.stream.Collectors;
import org.jkdp.forbidden.Points;

public class InProgressSetState implements SetState{

  private final Set set;

  public InProgressSetState(Set set) {
    this.set = set;
  }

  @Override
  public SetState nextState() {
    if (set.getPlayerScore().values().stream().allMatch((v -> v.getCurrentScore() == Points.FOURTY))) {
      return new DeuceSetState(this.set);
    }
    else{
      return this;
    }
  }

  @Override
  public String renderScore() {
    return this.set.getPlayerScore().entrySet()
            .stream().map(e -> e.getKey().name() + " " + e.getValue().getCurrentScore().getValue())
            .collect(Collectors.joining(" / "));
  }
}
