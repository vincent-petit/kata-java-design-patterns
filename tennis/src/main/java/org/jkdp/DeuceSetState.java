package org.jkdp;

import java.util.stream.Collectors;

public class DeuceSetState implements SetState{

  private final Set set;

  public DeuceSetState(Set set) {
    this.set = set;
  }

  @Override
  public SetState nextState() {
    return this;
  }

  @Override
  public String renderScore() {
    return "DEUCE";
  }
}
