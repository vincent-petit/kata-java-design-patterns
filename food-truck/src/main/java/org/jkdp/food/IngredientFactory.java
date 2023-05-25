package org.jkdp.food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jkdp.Ingredient;

public class IngredientFactory {

  private final Pattern additionalIngredientPattern = Pattern.compile("(with|and) (\\w+)");
  private final Pattern excludedIngredientPattern = Pattern.compile("(without|and without) (\\w+)");

  public List<Ingredient> toAdditionalIngredients(String order) {
    return extractIngredientFromPattern(order, additionalIngredientPattern, i -> !"without".equals(i));
  }

  public List<Ingredient> toExcludedIngredients(String order) {
    return extractIngredientFromPattern(order, excludedIngredientPattern);
  }

  private List<Ingredient> extractIngredientFromPattern(String order, Pattern pattern) {
    return extractIngredientFromPattern(order, pattern, i -> true);
  }
  private List<Ingredient> extractIngredientFromPattern(String order, Pattern pattern, Predicate<String> matchingPredicate) {
    Matcher matcher = pattern.matcher(order);
    var ingredientsString = new ArrayList<String>();

    while(matcher.find()) {
      String ingredient = matcher.group(2);

      if (matchingPredicate.test(ingredient)) {
        ingredientsString.add(ingredient);
      }
    }
    return ingredientsString.stream()
            .map(Ingredient::new)
            .collect(Collectors.toList());
  }

}
