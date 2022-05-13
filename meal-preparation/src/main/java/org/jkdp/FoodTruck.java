package org.jkdp;

import org.jkdp.forbidden.food.Dish;
import org.jkdp.forbidden.food.IngredientName;
import org.jkdp.forbidden.fridge.Fridge;
import org.jkdp.forbidden.shelf.Shelf;

public class FoodTruck {

  Fridge fridge = new Fridge();

  public Dish makeRecipe(){
    Dish dish = new Dish();
    dish.add(fridge.get(IngredientName.FROZEN_POTATO));
    dish.add(fridge.get(IngredientName.FROZEN_POTATO));
    dish.add(fridge.get(IngredientName.SAUSAGE));
    return dish;
  }

  public Dish makeBetterRecipe(){
    Dish dish = new Dish();
    dish.add(fridge.get(IngredientName.FROZEN_POTATO));
    dish.add(fridge.get(IngredientName.FROZEN_POTATO));
    dish.add(fridge.get(IngredientName.SAUSAGE));
    dish.add(fridge.get(IngredientName.ONION));
    return dish;
  }

}
