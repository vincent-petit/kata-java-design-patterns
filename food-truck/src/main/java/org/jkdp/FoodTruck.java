package org.jkdp;

import java.util.Locale;
import org.jkdp.command.BurgerCommand;
import org.jkdp.command.PaniniCommand;
import org.jkdp.command.PizzaCommand;

public class FoodTruck {

  private final PizzaCommand pizzaCommand = new PizzaCommand();
  private final BurgerCommand burgerCommand = new BurgerCommand();
  private final PaniniCommand paniniCommand = new PaniniCommand();

  public Food makeFood(String mealOrder){
    if (mealOrder.toLowerCase(Locale.ROOT).contains("pizza")) {
      return pizzaCommand.makeFood(mealOrder);
    }
    if (mealOrder.toLowerCase(Locale.ROOT).contains("panini")) {
      return paniniCommand.makeFood(mealOrder);
    }
    if (mealOrder.toLowerCase(Locale.ROOT).contains("burger")) {
      return burgerCommand.makeFood(mealOrder);
    }
    return null;
  }

}
