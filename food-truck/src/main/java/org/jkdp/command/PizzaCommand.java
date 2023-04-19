package org.jkdp.command;

import org.jkdp.Food;

public class PizzaCommand extends Command {
  public PizzaCommand(String mealOrder) {
    super(mealOrder);
  }

  @Override
  public Food makeFood() {
    if (mealOrder.toLowerCase().contains("margharita")) {
      return new Food("Margh. Pizza", 13.2d);
    }
    if (mealOrder.toLowerCase().contains("hawaiian")) {
      return new Food("Pineapple Pizza", 15.7d);
    }
    return null;
  }
}
