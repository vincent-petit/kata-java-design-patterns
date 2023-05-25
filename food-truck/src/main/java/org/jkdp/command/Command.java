package org.jkdp.command;

import org.jkdp.Food;
import org.jkdp.food.IngredientFactory;

public abstract class Command {
  String mealOrder;
  IngredientFactory ingredientFactory = new IngredientFactory();

  protected Command(String mealOrder) {
    this.mealOrder = mealOrder;
  }

  public abstract Food makeFood();


}
