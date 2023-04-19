package org.jkdp;

import java.util.ArrayList;
import java.util.List;
import org.jkdp.command.Command;
import org.jkdp.command.CommandHandler;

public class FoodTruck {
  public List<Food> foods = new ArrayList<>();
  CommandHandler commandHandler = new CommandHandler();
  public List<Food> makeFoods(String... mealOrder) {
    List<Command> commands = commandHandler.handleOrders(mealOrder);
    commands.stream().forEach(c -> foods.add(c.makeFood()));
    return foods;
  }
  public Food makeFood(String mealOrder) {
    this.makeFoods(mealOrder);
    return foods.get(0);
  }

}
