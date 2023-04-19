package org.jkdp.command;

import org.jkdp.Food;

public class PaniniCommand extends Command {
  public PaniniCommand(String mealOrder) {
    super(mealOrder);
  }

  @Override
  public Food makeFood() {
    return new Food("PANINI", 7.0d);
  }
}
