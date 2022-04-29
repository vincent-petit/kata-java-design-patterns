package org.jkdp;

public class FoodTruck {

  public Food makeFood(String mealOrder){
    if("Margharita pizza".equals(mealOrder)){
      return new Food() {
        public String getName() {
          return "Margh. Pizza";
        }
        public Double getCost() {
          return 13.2d;
        }
      };
    }
    if("Hawaiian pizza".equals(mealOrder)){
      return new Food() {
        public String getName() {
          return "Pineapple Pizza";
        }
        public Double getCost() {
          return 15.7d;
        }
      };
    }
    if("Panini".equals(mealOrder)){
      return new Food() {
        public String getName() {
          return "PANINI";
        }
        public Double getCost() {
          return 7.0d;
        }
      };
    }
    return null;
  }

}
