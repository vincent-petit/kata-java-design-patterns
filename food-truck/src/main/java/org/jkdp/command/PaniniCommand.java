package org.jkdp.command;

import org.jkdp.Food;

public class PaniniCommand implements Command {
  @Override
  public Food makeFood(String mealOrder) {
    return new Food("PANINI", 7.0d);
  }
}
