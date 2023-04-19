package org.jkdp.command;

import org.jkdp.Food;

public abstract class Command {
  String mealOrder;

  protected Command(String mealOrder) {
    this.mealOrder = mealOrder;
  }

  public abstract Food makeFood();

}
