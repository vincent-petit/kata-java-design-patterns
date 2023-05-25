package org.jkdp.food;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.jkdp.Ingredient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IngredientFactoryTest {
  IngredientFactory ingredientFactory = new IngredientFactory();

  public static Stream<Arguments> provideIngredientUseCase() {
    return Stream.of(Arguments.of("Burger with bacon", List.of("bacon")),
                     Arguments.of("Burger with bacon and cheddar", List.of("bacon", "cheddar"))
                     Arguments.of("Burger with bacon and cheddar without tomate", List.of("bacon", "cheddar"))
    );
  }

  @ParameterizedTest()
  @MethodSource("provideIngredientUseCase")
  void nominal(String order, List<String> ingredients) {
    Assertions.assertThat(ingredientFactory.toIngredients(order))
            .extracting(Ingredient::getName)
            .containsExactlyElementsOf(ingredients);
  }
}