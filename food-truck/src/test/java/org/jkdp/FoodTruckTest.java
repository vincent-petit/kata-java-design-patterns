package org.jkdp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FoodTruckTest {

  @Test
  void makeFood_Panini_paniniReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Panini";

    var food = foodTruck.makeFood(mealOrder);
    assertThat(food).isNotNull().returns("PANINI", Food::getName);
  }


  @Test
  void makeFood_burgerWithBacon_BurgerReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Burger with bacon";

    var food = foodTruck.makeFood(mealOrder);
    assertThat(food).isNotNull().returns("Burger with bacon", Food::getName);
    assertThat(food).isNotNull().returns(12.5d, Food::getCost);
  }

  @Test
  void makeFood_burgerWithoutBacon_BurgerReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Burger without bacon";

    var food = foodTruck.makeFood(mealOrder);
    assertThat(food).isNotNull().returns("Burger without bacon", Food::getName);
    assertThat(food).isNotNull().returns(12.5d, Food::getCost);
  }
}
