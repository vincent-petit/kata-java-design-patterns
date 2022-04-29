package org.jkdp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FoodTruckTest {

  @Test
  void makeFood_Panini_paniniReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Panini";

    var food = foodTruck.makeFood(mealOrder);

    assertEquals("PANINI", food.getName());
  }
}
