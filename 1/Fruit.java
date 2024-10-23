package FoodLib;

import java.util.Map;

public class Fruit extends Food {
    public Fruit(String name, boolean edible, Map<String, Double> nutritionalValue) {
        super(edible, nutritionalValue, name);
    }


}
