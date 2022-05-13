package org.jkdp.forbidden.fridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.jkdp.forbidden.food.IngredientName;
import org.junit.jupiter.api.Test;

class FridgeTest {

  @Test
  void get_inStock_returned() {
    Fridge fridge = new Fridge();
    assertThat(fridge.get(IngredientName.SAUSAGE)).isNotNull();
  }

  @Test
  void get_notInStock_exception() {
    Fridge fridge = new Fridge();
    assertThatThrownBy(()->fridge.get(IngredientName.ONION)).isInstanceOf(FridgeException.class);
  }
}
