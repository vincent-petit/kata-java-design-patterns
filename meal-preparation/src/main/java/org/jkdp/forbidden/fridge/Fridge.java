package org.jkdp.forbidden.fridge;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jkdp.forbidden.food.IngredientName;

public class Fridge {

  Map<IngredientName, Stock> stocks = new HashMap<>();

  public Fridge() {
    this.stocks.put(IngredientName.FROZEN_POTATO, new Stock( new ColdIngredient(IngredientName.FROZEN_POTATO),137));
    this.stocks.put(IngredientName.SAUSAGE, new Stock( new ColdIngredient(IngredientName.SAUSAGE),91));
  }

  public ColdIngredient get(IngredientName name) {
    var stock =  stocks.get(name);
    if(stock == null){throw new FridgeException(name.name() + " was not found");}
    if(stock.quantity <= 0 ){throw new FridgeException("No more " + name.name());}
    stock.quantity--;
    return stock.ingredient;
  }

  @AllArgsConstructor
  @Getter
  private static class Stock {
    private ColdIngredient ingredient;
    private int quantity;
  }

}
