package org.jkdp.command;

import org.jkdp.Food;

public class BurgerCommand extends Command {
  public BurgerCommand(String mealOrder) {
    super(mealOrder);
  }

  @Override
  public Food makeFood() {
    Food burger = new Food("Burger", 12.5d);
    if (mealOrder.toLowerCase().contains("with bacon")) {
      return burger.withIngredient("bacon");
    }
    if (mealOrder.toLowerCase().contains("without bacon")) {
      return burger.withoutIngredient("bacon");
    }
    return null;
  }
}
