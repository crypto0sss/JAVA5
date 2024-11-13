package repo;

import food.Food;

import java.util.List;

public interface FoodRepository<T> {
    void addFood(Food food); // Create
    Food[] getAllFoods();
    Food getFoodByName(String name); // Read by name
    void updateFood(Food food); // Update
    void deleteFood(String name); // Delete
    List<Food> findFoodsByEndingLetter(char letter); // Custom Read


}