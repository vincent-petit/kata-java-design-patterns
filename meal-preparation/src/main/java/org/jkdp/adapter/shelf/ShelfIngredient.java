package org.jkdp.adapter.shelf;

import lombok.Builder;
import org.jkdp.forbidden.food.Ingredient;
import org.jkdp.forbidden.food.IngredientName;

@Builder
public class ShelfIngredient implements Ingredient {

  private IngredientName ingredientName;

  @Override
  public IngredientName getName() {
    return ingredientName;
  }
}
