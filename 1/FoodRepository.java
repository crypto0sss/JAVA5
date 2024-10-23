
import java.util.List;

public interface FoodRepository {
    void addFood(Food food); // Create
    List<Food> getAllFoods(); // Read
    Food getFoodByName(String name); // Read by name
    void updateFood(Food food); // Update
    void deleteFood(String name); // Delete
    List<Food> findFoodsByEndingLetter(char letter); // Custom Read
}