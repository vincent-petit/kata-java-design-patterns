package org.jkdp.forbidden.fridge;

import lombok.AllArgsConstructor;
import org.jkdp.forbidden.food.Ingredient;
import org.jkdp.forbidden.food.IngredientName;

@AllArgsConstructor
public class ColdIngredient implements Ingredient {

  private IngredientName ingredientName;

  @Override
  public IngredientName getName() {
    return ingredientName;
  }
}
