package org.jkdp;

import lombok.AllArgsConstructor;
import org.jkdp.adapter.IngredientProviderChain;
import org.jkdp.forbidden.food.Dish;
import org.jkdp.forbidden.food.IngredientName;
import org.jkdp.forbidden.fridge.Fridge;

@AllArgsConstructor
public class FoodTruck {

  IngredientProviderChain chain;

  public Dish makeRecipe() {
    Dish dish = new Dish();
    dish.add(chain.getIngredient(IngredientName.FROZEN_POTATO));
    dish.add(chain.getIngredient(IngredientName.FROZEN_POTATO));
    dish.add(chain.getIngredient(IngredientName.SAUSAGE));
    return dish;
  }

  public Dish makeBetterRecipe() {
    Dish dish = new Dish();
    dish.add(chain.getIngredient(IngredientName.FROZEN_POTATO));
    dish.add(chain.getIngredient(IngredientName.FROZEN_POTATO));
    dish.add(chain.getIngredient(IngredientName.SAUSAGE));
    dish.add(chain.getIngredient(IngredientName.ONION));
    return dish;
  }

}
