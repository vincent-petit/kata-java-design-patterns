package org.jkdp.command;

import org.jkdp.Food;

public interface Command {
  Food makeFood(String mealOrder);
}
