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
    assertThat(food).isNotNull().returns("PANINI", Food::getName)
            .returns(10.0D, Food::getCost);
  }


  @Test
  void makeFood_burgerWithBacon_BurgerReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Burger with bacon";

    var food = foodTruck.makeFood(mealOrder);
    assertThat(food).isNotNull().returns("Burger with bacon", Food::getName)
            .returns(12.0D, Food::getCost);
  }


  @Test
  void makeFood_burgerWithBaconAndCheddar_BurgerReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Burger with bacon and cheddar";

    var food = foodTruck.makeFood(mealOrder);
    assertThat(food).isNotNull().returns("Burger with bacon and cheddar", Food::getName)
            .returns(14.0D, Food::getCost);
  }

  @Test
  void makeFood_burgerWithoutBacon_BurgerReturned() {
    FoodTruck foodTruck = new FoodTruck();
    String mealOrder = "Burger without bacon";

    var food = foodTruck.makeFood(mealOrder);
    assertThat(food).isNotNull().returns("Burger without bacon", Food::getName)
            .returns(10.0D, Food::getCost);
  }
}
