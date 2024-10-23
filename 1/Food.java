package FoodLib;

import java.util.Map;

public abstract class Food {
    private final boolean edible;
    private final Map<String, Double> nutritionalValue;
    private final String name;

    public Food(boolean edible, Map<String, Double> nutritionalValue, String name) {
        this.edible = edible;
        this.nutritionalValue = nutritionalValue;
        this.name = name;
    }

    private double calculateEnergyValue() {
        double protein = nutritionalValue.getOrDefault("Белки", 0.0);
        double fat = getNutritionalValue().getOrDefault("Жиры", 0.0);
        double carbs = getNutritionalValue().getOrDefault("Углеводы", 0.0);

        return 4 * protein + 9 * fat + 4 * carbs;
    }


    public boolean isEdible() {
        return edible;
    }

    public Map<String, Double> getNutritionalValue() {
        return nutritionalValue;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return " " + name + "\n Съедобно:" + (edible ? "Да" : "Нет") + "\n Энергетическая ценность "+ name + " : " + calculateEnergyValue();
    }
}
