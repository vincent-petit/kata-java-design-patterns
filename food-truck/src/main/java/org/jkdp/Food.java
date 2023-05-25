package org.jkdp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Food implements NamedAndPriced {

  private final String baseName;
  private final double baseCost;
  private final List<Ingredient> ingredientAdded = new ArrayList<>();
  private final List<Ingredient> ingredientRemoved = new ArrayList<>();


  public Food(String baseName, double baseCost) {
    this.baseName = baseName;
    this.baseCost = baseCost;
  }
  public Food withIngredient(Ingredient ingredient) {
    ingredientAdded.add(ingredient);
    return this;
  }

  public Food withoutIngredient(Ingredient ingredient) {
    ingredientRemoved.add(ingredient);
    return this;
  }


  @Override
  public String getName() {
    return baseName
            + joinIngredients(ingredientAdded, " with ")
            + joinIngredients(ingredientRemoved, " without ");
  }

  private String joinIngredients(List<Ingredient> ingredientAdded, String prefix) {
    if (ingredientAdded.isEmpty()) {
      return "";
    }
    return ingredientAdded.stream()
            .map(Ingredient::getName)
            .collect(Collectors.joining(", ", prefix, ""));
  }

  @Override
  public Double getCost() {
    return baseCost + ingredientAdded.stream().mapToDouble(Ingredient::getCost).sum();
  }

}
