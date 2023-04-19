package org.jkdp.command;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandHandler {

  List<Command> commands;

  public List<Command> handleOrders(String... mealOrder) {
    return Arrays.stream(mealOrder).map(this::toCommand)
            .flatMap(Optional::stream)
            .collect(Collectors.toList());
  }
  Optional<Command> toCommand(String mealOrder) {
    if (mealOrder.toLowerCase(Locale.ROOT).contains("pizza")) {
      return Optional.of(new PizzaCommand( mealOrder));
    }
    if (mealOrder.toLowerCase(Locale.ROOT).contains("panini")) {
      return Optional.of(new PaniniCommand(mealOrder));
    }
    if (mealOrder.toLowerCase(Locale.ROOT).contains("burger")) {
      return Optional.of(new BurgerCommand(mealOrder));
    }
    return Optional.empty();
  }
}
