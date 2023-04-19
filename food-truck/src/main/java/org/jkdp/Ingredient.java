package org.jkdp;

public class Ingredient implements NamedAndPriced {

  private String name;

  public Ingredient(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Double getCost() {
    return 0d;
  }
}
