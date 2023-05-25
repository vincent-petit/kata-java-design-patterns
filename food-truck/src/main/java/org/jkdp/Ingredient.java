package org.jkdp;

public class Ingredient implements NamedAndPriced {

  private final String name;
  private final double cost;


  public Ingredient(String name) {
    this(name, 2d);
  }
  public Ingredient(String name, Double cost) {
    this.name = name;
    this.cost = cost;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Double getCost() {
    return cost;
  }
}
