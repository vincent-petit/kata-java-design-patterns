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
    return Stream.of(Arguments.of("Burger", List.of()),
                     Arguments.of("Burger without tomato", List.of()),
                     Arguments.of("Burger with bacon", List.of("bacon")),
                     Arguments.of("Burger with bacon and cheddar", List.of("bacon", "cheddar")),
                     Arguments.of("Burger with bacon and cheddar and ananas", List.of("bacon", "cheddar", "ananas")),
                     Arguments.of("Burger with bacon and cheddar without tomato", List.of("bacon", "cheddar")),
                     Arguments.of("Burger with bacon and cheddar without tomato and without bun", List.of("bacon", "cheddar"))
    );
  }

  @ParameterizedTest()
  @MethodSource("provideIngredientUseCase")
  void toAdditionalIngredients(String order, List<String> ingredients) {
    Assertions.assertThat(ingredientFactory.toAdditionalIngredients(order))
            .extracting(Ingredient::getName)
            .containsExactlyElementsOf(ingredients);
  }

  public static Stream<Arguments> provideExcludedIngredientUseCase() {
    return Stream.of(Arguments.of("Burger", List.of()),
                     Arguments.of("Burger with bacon", List.of()),
                     Arguments.of("Burger without tomato and without bun", List.of("tomato", "bun")),
                     Arguments.of("Burger with bacon and cheddar without tomato and without bun", List.of("tomato", "bun"))
    );
  }

  @ParameterizedTest()
  @MethodSource("provideExcludedIngredientUseCase")
  void toExcludedIngredients(String order, List<String> ingredients) {
    Assertions.assertThat(ingredientFactory.toExcludedIngredients(order))
            .extracting(Ingredient::getName)
            .containsExactlyElementsOf(ingredients);
  }
}