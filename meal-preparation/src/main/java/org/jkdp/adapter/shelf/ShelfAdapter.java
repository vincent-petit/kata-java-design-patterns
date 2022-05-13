package org.jkdp.adapter.shelf;

import java.io.IOException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.jkdp.adapter.IngredientProviderAdapter;
import org.jkdp.forbidden.food.Ingredient;
import org.jkdp.forbidden.food.IngredientName;
import org.jkdp.forbidden.shelf.Shelf;
import org.jkdp.forbidden.shelf.ShelfException;

@AllArgsConstructor
public class ShelfAdapter implements IngredientProviderAdapter {

  private final Shelf shelf;
  private final ShelfNameAdapater shelfNameAdapater;

  @Override
  public Optional<Ingredient> getIngredient(IngredientName ingredientName) {
    Ingredient result = null;
    try {
      shelf.getOne(shelfNameAdapater.resolveName(ingredientName));
      result = ShelfIngredient.builder().ingredientName(ingredientName).build();
    } catch (ShelfException | IOException e) {
      //log.warn(e);
    }
    return Optional.ofNullable(result);
  }

}
