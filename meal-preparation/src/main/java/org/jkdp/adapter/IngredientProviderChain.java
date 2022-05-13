package org.jkdp.adapter;

import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.jkdp.forbidden.food.Ingredient;
import org.jkdp.forbidden.food.IngredientName;

@AllArgsConstructor
public class IngredientProviderChain {

  private final Set<IngredientProviderAdapter> ingredientProviderAdapterSet;

  public Ingredient getIngredient(IngredientName name) {
    Optional<Ingredient> ingredient = Optional.empty();
    for(IngredientProviderAdapter ingredientProviderAdapter: ingredientProviderAdapterSet){
      ingredient = ingredientProviderAdapter.getIngredient(name);
      if(ingredient.isPresent()){
        break;
      }
    }
    return ingredient.orElseThrow(IngredientAccessException::new);
  }
}
