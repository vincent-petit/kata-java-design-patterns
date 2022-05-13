package org.jkdp.forbidden.food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dish {
  private Map<IngredientName,Integer> ingredients = new HashMap<>();

  public void add(Ingredient ingredient) {
    ingredients.putIfAbsent(ingredient.getName(),0);
    ingredients.put(ingredient.getName(),ingredients.get(ingredient.getName())+1);
  }

  public String display(){
   return ingredients.entrySet().stream().map(e -> e.getKey().name() + " x"+e.getValue()).collect(Collectors.joining(", "));
  }

}
