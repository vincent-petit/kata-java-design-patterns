package org.jkdp.command;

import org.jkdp.Food;

public class BurgerCommand extends Command {
  public BurgerCommand(String mealOrder) {
    super(mealOrder);
  }

  @Override
  public Food makeFood() {
    Food burger = new Food("Burger", 12.0d);
    ingredientFactory.toAdditionalIngredients(mealOrder.toLowerCase()).forEach(burger::withIngredient);
    ingredientFactory.toExcludedIngredients(mealOrder.toLowerCase()).forEach(burger::withoutIngredient);

    return burger;
  }
}
