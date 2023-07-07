package org.jkdp;

import java.util.stream.Collectors;

public class AdvantageSetState implements SetState{

  private final Set set;

  public AdvantageSetState(Set set) {
    this.set = set;
  }

  @Override
  public SetState nextState() {
    return this;
  }

  @Override
  public String renderScore() {
     return this.set.getPlayerScore().entrySet()
            .stream().map(e -> e.getKey().name() + " " + e.getValue().getCurrentScore().getValue()
                    + (e.getKey() == set.getLastPlayerScored() ? " (A)" : ""))
            .collect(Collectors.joining(" / "));
  }
}
