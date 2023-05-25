package org.jkdp.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jkdp.Ingredient;

public class IngredientFactory {
  List<Ingredient> toIngredients(String order) {
//    Pattern pattern = Pattern.compile(".*with (\\w*)( and (\\w*))*");
    Pattern pattern = Pattern.compile("(with|and) (\\w+)");
    Matcher matcher = pattern.matcher(order);
    var ingredientsString = new ArrayList<String>();

    while(matcher.find()) {
      ingredientsString.add(matcher.group(2));
    }
    return ingredientsString.stream()
            .map(Ingredient::new)
            .collect(Collectors.toList());
  }
}
