package org.jkdp;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Set;
import lombok.SneakyThrows;
import org.jkdp.adapter.IngredientProviderChain;
import org.jkdp.adapter.fridge.FridgeAdapter;
import org.jkdp.adapter.shelf.ShelfAdapter;
import org.jkdp.adapter.shelf.ShelfNameAdapater;
import org.jkdp.forbidden.food.Dish;
import org.jkdp.forbidden.food.IngredientName;
import org.jkdp.forbidden.fridge.Fridge;
import org.jkdp.forbidden.shelf.Shelf;
import org.junit.jupiter.api.Test;

class FoodTruckTest {

  @SneakyThrows
  @Test
  void makeRecipe_inAnyCase_hasPotatoesAndSausages(){
    FoodTruck foodTruck = setup();
    assertThat(foodTruck.makeRecipe()).isNotNull().returns("FROZEN_POTATO x2, SAUSAGE x1", Dish::display);
  }

  @Test
  @SneakyThrows
  //RED WHEN STARTING
  void makeBetterRecipe_inAnyCase_hasPotatoesAndSausages(){
    FoodTruck foodTruck = setup();
    assertThat(foodTruck.makeBetterRecipe()).isNotNull().returns("FROZEN_POTATO x2, SAUSAGE x1, ONION x1", Dish::display);
  }

  private FoodTruck setup() throws IOException {
    var startingStock = List.of("SALT;999", "ONION;10");
    File sourceFile = File.createTempFile("shelf", ".txt");
    Files.write(sourceFile.toPath(), startingStock, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

    Shelf shelf = new Shelf(sourceFile);
    ShelfAdapter shelfAdapter = new ShelfAdapter(shelf,new Adapater());

    Fridge fridge = new Fridge();
    FridgeAdapter fridgeAdapter = new FridgeAdapter(fridge);

    IngredientProviderChain chain = new IngredientProviderChain(Set.of(shelfAdapter, fridgeAdapter));

    FoodTruck foodTruck = new FoodTruck(chain);

    return foodTruck;
  }

  private static class Adapater implements ShelfNameAdapater {

    @Override
    public String resolveName(IngredientName ingredientName) {
      return ingredientName.name();
    }
  }

}
