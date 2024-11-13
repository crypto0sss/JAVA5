
import food.*;
import repo.FoodRepository;
import repo.InMemoryFoodRepositoryImp;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodRepository foodRepository = new InMemoryFoodRepositoryImp();

        // Добавляем еду в репозиторий
        addFoodToRepository(foodRepository);

        // Чтение всех продуктов
        System.out.println("Все продукты:");
        displayAllFoods(foodRepository);

        // Поиск продукта по имени
        System.out.println("Поиск 'Яблоко':");
        Food apple = foodRepository.getFoodByName("Яблоко");
        System.out.println(apple);

        // Обновление продукта
        System.out.println("Обновление 'Яблоко':");
        Map<String, Double> newAppleNutritionalValue = Map.of("Белки", 0.6, "Жиры", 0.2, "Углеводы", 11.0);
        foodRepository.updateFood(new Fruit("Яблоко", true, newAppleNutritionalValue));
        System.out.println(foodRepository.getFoodByName("Яблоко"));

        // Удаление продукта
        System.out.println("Удаление 'Груша':");
        foodRepository.deleteFood("Груша");
        displayAllFoods(foodRepository);

        // Поиск по букве
        System.out.print("Введите букву, на которое оканчивается название еды: ");
        char targetLetter = sc.nextLine().charAt(0);
        List<Food> foundFoods = foodRepository.findFoodsByEndingLetter(targetLetter);
        System.out.println("Продукты, оканчивающиеся на '" + targetLetter + "':");
        for (Food food : foundFoods) {
            System.out.println(food.getName());
        }
    }

    private static void addFoodToRepository(FoodRepository repository) {
        // Курица
        Map<String, Double> chickenNutritionalValue = Map.of("Белки", 20.8, "Жиры", 8.8, "Углеводы", 0.6);
        repository.addFood(new Meat("Курица", true, chickenNutritionalValue));

        // Индейка
        Map<String, Double> turkeyNutritionalValue = Map.of("Белки", 21.6, "Жиры", 12.0, "Углеводы", 0.8);
        repository.addFood(new Meat("Индейка", true, turkeyNutritionalValue));

        // Баранина
        Map<String, Double> muttonNutritionalValue = Map.of("Белки", 18.2, "Жиры", 15.3, "Углеводы", 0.1);
        repository.addFood(new Meat("Баранина", false, muttonNutritionalValue));

        // Яблоко
        Map<String, Double> appleNutritionalValue = Map.of("Белки", 0.5, "Жиры", 0.3, "Углеводы", 10.0);
        repository.addFood(new Fruit("Яблоко", false, appleNutritionalValue));

        // Апельсин
        Map<String, Double> orangeNutritionalValue = Map.of("Белки", 1.0, "Жиры", 0.2, "Углеводы", 15.0);
        repository.addFood(new Fruit("Апельсин", true, orangeNutritionalValue));

        // Груша
        Map<String, Double> pearNutritionalValue = Map.of("Белки", 0.6, "Жиры", 0.4, "Углеводы", 12.0);
        repository.addFood(new Fruit("Груша", true, pearNutritionalValue));

        // Помидор
        Map<String, Double> tomatoNutritionalValue = Map.of("Белки", 1.1, "Жиры", 0.2, "Углеводы", 3.8);
        repository.addFood(new Vegetable("Помидор", true, tomatoNutritionalValue));

        // Морковь
        Map<String, Double> carrotNutritionalValue = Map.of("Белки", 0.9, "Жиры", 0.2, "Углеводы", 0.2);
        repository.addFood(new Vegetable("Морковь", true, carrotNutritionalValue));

        // Картофель
        Map<String, Double> potatoNutritionalValue = Map.of("Белки", 2.0, "Жиры", 0.4, "Углеводы", 16.3);
        repository.addFood(new Vegetable("Картофель", true, potatoNutritionalValue));
    }

    public static void displayAllFoods(FoodRepository repository) {
        for (Food food : repository.getAllFoods()) {
            System.out.println(food.getName());
        }
    }
}