package org.jkdp;

import static org.assertj.core.api.Assertions.assertThat;

import org.jkdp.forbidden.food.Dish;
import org.junit.jupiter.api.Test;

class FoodTruckTest {

  FoodTruck foodTruck = new FoodTruck();

  @Test
  void makeRecipe_inAnyCase_hasPotatoesAndSausages(){
    assertThat(foodTruck.makeRecipe()).isNotNull().returns("SAUSAGE x1, FROZEN_POTATO x2", Dish::display);
  }

  @Test
  //RED WHEN STARTING
  void makeBetterRecipe_inAnyCase_hasPotatoesAndSausages(){
    assertThat(foodTruck.makeBetterRecipe()).isNotNull().returns("SAUSAGE x1, FROZEN_POTATO x2, ONION x1", Dish::display);
  }

}
