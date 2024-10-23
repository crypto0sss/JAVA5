package FoodLib;

import java.util.Map;

public class Vegetable extends Food {
    public Vegetable(String name, boolean edible, Map<String, Double> nutritionalValue) {
        super(edible, nutritionalValue, name);
    }


}
