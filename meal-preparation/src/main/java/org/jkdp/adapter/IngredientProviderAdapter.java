package org.jkdp.adapter;

import java.util.Optional;
import org.jkdp.forbidden.food.Ingredient;
import org.jkdp.forbidden.food.IngredientName;

public interface IngredientProviderAdapter {

  Optional<Ingredient> getIngredient(IngredientName ingredientName);

}
