package org.jkdp.adapter.fridge;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.jkdp.adapter.IngredientProviderAdapter;
import org.jkdp.forbidden.food.Ingredient;
import org.jkdp.forbidden.food.IngredientName;
import org.jkdp.forbidden.fridge.Fridge;
import org.jkdp.forbidden.fridge.FridgeException;

@AllArgsConstructor
public class FridgeAdapter implements IngredientProviderAdapter {

  private final Fridge fridge;

  @Override
  public Optional<Ingredient> getIngredient(IngredientName ingredientName) {
    Ingredient result = null;
    try {
      result = fridge.get(ingredientName);
    } catch (FridgeException e) {
      //log.warn(e);
    }
    return Optional.ofNullable(result);
  }
}
