package org.jkdp.command;

import org.jkdp.Food;

public class BurgerCommand implements Command {
  @Override
  public Food makeFood(String mealOrder) {
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
