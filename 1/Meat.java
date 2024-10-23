package FoodLib;

import java.util.Map;

public class Meat extends Food {
    public Meat(String name, boolean edible, Map<String, Double> nutritionalValue) {
        super(edible, nutritionalValue, name);
    }
}
