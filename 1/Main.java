import FoodLib.Food;
import FoodLib.Fruit;
import FoodLib.Meat;
import FoodLib.Vegetable;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Food> foodList = new ArrayList<>();
        List<String> foodNames = new ArrayList<>();

        //Курица
        Map<String, Double> chickenNutritionalValue = new HashMap<>();
        chickenNutritionalValue.put("Белки", 20.8);
        chickenNutritionalValue.put("Жиры", 8.8);
        chickenNutritionalValue.put("Углеводы", 0.6);
        foodList.add(new Meat("Курица", true, chickenNutritionalValue));

        //Индейка
        Map<String, Double> turkeyNutritionalValue = new HashMap<>();
        turkeyNutritionalValue.put("Белки", 21.6);
        turkeyNutritionalValue.put("Жиры", 12.0);
        turkeyNutritionalValue.put("Углеводы", 0.8);

        foodList.add(new Meat("Индейка", true, turkeyNutritionalValue));

        //Баранина
        Map<String, Double> muttonNutritionalValue = new HashMap<>();
        muttonNutritionalValue.put("Белки", 18.2);
        muttonNutritionalValue.put("Жиры", 15.3);
        muttonNutritionalValue.put("Углеводы", 0.1);
        foodList.add(new Meat("Баранина", false, muttonNutritionalValue));

        //Яблоко
        Map<String, Double> appleNutritionalValue = new HashMap<>();
        appleNutritionalValue.put("Белки", 0.5);
        appleNutritionalValue.put("Жиры", 0.3);
        appleNutritionalValue.put("Углеводы", 10.0);
        foodList.add(new Fruit("Яблоко", false, appleNutritionalValue));

        //Апельсин
        Map<String, Double> orangeNutritionalValue = new HashMap<>();
        orangeNutritionalValue.put("Белки", 1.0);
        orangeNutritionalValue.put("Жиры", 0.2);
        orangeNutritionalValue.put("Углеводы", 15.0);
        foodList.add(new Fruit("Апельсин", true, orangeNutritionalValue));

        //Груша
        Map<String, Double> pearNutritionalValue = new HashMap<>();
        pearNutritionalValue.put("Белки", 0.6);
        pearNutritionalValue.put("Жиры", 0.4);
        pearNutritionalValue.put("Углеводы", 12.0);
        foodList.add(new Fruit("Груша", true, pearNutritionalValue));

        //Помидор
        Map<String, Double> tomatoNutritionalValue = new HashMap<>();
        tomatoNutritionalValue.put("Белки", 1.1);
        tomatoNutritionalValue.put("Жиры", 0.2);
        tomatoNutritionalValue.put("Углеводы", 3.8);
        foodList.add(new Vegetable("Помидор", true, tomatoNutritionalValue));

        //Морковь
        Map<String, Double> carrotNutritionalValue = new HashMap<>();
        carrotNutritionalValue.put("Белки", 0.9);
        carrotNutritionalValue.put("Жиры", 0.2);
        carrotNutritionalValue.put("Углеводы", 0.2);
        foodList.add(new Vegetable("Помидор", true, carrotNutritionalValue));

        //Картофель
        Map<String, Double> potatoNutritionalValue = new HashMap<>();
        potatoNutritionalValue.put("Белки", 2.0);
        potatoNutritionalValue.put("Жиры", 0.4);
        potatoNutritionalValue.put("Углеводы", 16.3);
        foodList.add(new Vegetable("Картофель", true, potatoNutritionalValue));

        for (Food food : foodList) {
            System.out.println("Создан объект " + food.getName());
            System.out.println(food);
            foodNames.add(food.getName());
        }

        System.out.print("Введите букву, на которое оканчивается название еды: ");
        char targetLetter = sc.nextLine().charAt(0);

        for (String food : foodNames) {
            if (food.toLowerCase().endsWith(String.valueOf(targetLetter))) {
                System.out.println(food);
            }


        }
    }
}
