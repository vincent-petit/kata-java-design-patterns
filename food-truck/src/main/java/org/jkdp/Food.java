package org.jkdp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Food {

  private final String baseName;
  private final double baseCost;
  private final List<String> ingredientAdded = new ArrayList<>();
  private final List<String> ingredientRemoved = new ArrayList<>();


  public Food(String baseName, double baseCost) {
    this.baseName = baseName;
    this.baseCost = baseCost;
  }
  public Food withIngredient(String ingredient) {
    ingredientAdded.add(ingredient);
    return this;
  }

  public Food withoutIngredient(String ingredient) {
    ingredientRemoved.add(ingredient);
    return this;
  }

  Food(String baseName, double baseCost, List<String> ingredientAdded, List<String> ingredientRemoved) {
    this.baseName = baseName;
    this.baseCost = baseCost;
    this.ingredientAdded.addAll(ingredientAdded);
    this.ingredientRemoved.addAll(ingredientRemoved);
  }

  String getName() {
    return baseName
            + (ingredientAdded.isEmpty() ? "": ingredientAdded.stream().collect(Collectors.joining(", ", " with ", "")))
            + (ingredientRemoved.isEmpty() ? "": ingredientRemoved.stream().collect(Collectors.joining(", ", " without ", "")));
  }
  Double getCost() {
    return baseCost;
  }

}
