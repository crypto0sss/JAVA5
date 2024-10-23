
import java.util.ArrayList;
import java.util.List;

public class InMemoryFoodRepository implements FoodRepository {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public void addFood(Food food) {
        foodList.add(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return new ArrayList<>(foodList);
    }

    @Override
    public Food getFoodByName(String name) {
        for (Food food : foodList) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }
        return null;
    }

    @Override
    public void updateFood(Food food) {
        for (int i = 0; i < foodList.size(); i++) {
            if (foodList.get(i).getName().equalsIgnoreCase(food.getName())) {
                foodList.set(i, food);
                return;
            }
        }
    }

    @Override
    public void deleteFood(String name) {
        foodList.removeIf(food -> food.getName().equalsIgnoreCase(name));
    }

    @Override
    public List<Food> findFoodsByEndingLetter(char letter) {
        List<Food> result = new ArrayList<>();
        for (Food food : foodList) {
            if (food.getName().toLowerCase().endsWith(String.valueOf(letter).toLowerCase())) {
                result.add(food);
            }
        }
        return result;
    }
}