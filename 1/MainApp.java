import food.*;
import repo.FoodRepository;
import repo.InMemoryFoodRepositoryImp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Map;

public class MainApp extends Application {

    private final FoodRepository foodRepository = new InMemoryFoodRepositoryImp();
    private final ObservableList<Food> foodObservableList = FXCollections.observableArrayList();
    private final DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        addFoodToRepository(foodRepository);
        foodObservableList.addAll(foodRepository.getAllFoods());

        ListView<Food> foodListView = new ListView<>(foodObservableList);
        foodListView.setPrefHeight(200);

        TextField foodNameField = new TextField();
        foodNameField.setPromptText("Название продукта");

        TextField proteinField = new TextField();
        proteinField.setPromptText("Белки");

        TextField fatField = new TextField();
        fatField.setPromptText("Жиры");

        TextField carbField = new TextField();
        carbField.setPromptText("Углеводы");

        Button addButton = new Button("Добавить");
        addButton.setStyle("-fx-background-color: #673ab7; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-padding: 10px;");
        addButton.setOnAction(e -> {
            String name = foodNameField.getText();
            if (foodRepository.getFoodByName(name) != null) {
                showAlert("Ошибка", "Продукт с таким именем уже существует!");
                return;
            }
            double protein = Double.parseDouble(proteinField.getText());
            double fat = Double.parseDouble(fatField.getText());
            double carb = Double.parseDouble(carbField.getText());

            Map<String, Double> nutritionalValue = Map.of("Белки", protein, "Жиры", fat, "Углеводы", carb);
            Food newFood = new Fruit(name, true, nutritionalValue);
            foodRepository.addFood(newFood);
            foodObservableList.add(newFood);

            foodNameField.clear();
            proteinField.clear();
            fatField.clear();
            carbField.clear();
        });

        Button deleteButton = new Button("Удалить");
        deleteButton.setStyle("-fx-background-color: #d32f2f; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-padding: 10px;");
        deleteButton.setOnAction(e -> {
            Food selectedFood = foodListView.getSelectionModel().getSelectedItem();
            if (selectedFood != null) {
                foodRepository.deleteFood(selectedFood.getName());
                foodObservableList.remove(selectedFood);
            }
        });

        Button updateButton = new Button("Обновить");
        updateButton.setStyle("-fx-background-color: #00796b; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-padding: 10px;");
        updateButton.setOnAction(e -> {
            Food selectedFood = foodListView.getSelectionModel().getSelectedItem();
            if (selectedFood == null) {
                showAlert("Ошибка", "Выберите продукт для обновления!");
                return;
            }
            String name = foodNameField.getText();
            if (!name.equals(selectedFood.getName()) && foodRepository.getFoodByName(name) != null) {
                showAlert("Ошибка", "Продукт с таким именем уже существует!");
                return;
            }
            double protein = Double.parseDouble(proteinField.getText());
            double fat = Double.parseDouble(fatField.getText());
            double carb = Double.parseDouble(carbField.getText());

            Map<String, Double> nutritionalValue = Map.of("Белки", protein, "Жиры", fat, "Углеводы", carb);
            Food updatedFood = new Fruit(name, true, nutritionalValue);
            foodRepository.updateFood(updatedFood);

            int selectedIndex = foodObservableList.indexOf(selectedFood);
            foodObservableList.set(selectedIndex, updatedFood);
        });

        HBox inputFields = new HBox(10, foodNameField, proteinField, fatField, carbField);
        inputFields.setAlignment(Pos.CENTER);
        inputFields.setPadding(new Insets(10, 0, 10, 0));

        HBox actionButtons = new HBox(10, addButton, updateButton, deleteButton);
        actionButtons.setAlignment(Pos.CENTER);
        actionButtons.setPadding(new Insets(10, 0, 10, 0));

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #e0f7fa;");
        vbox.getChildren().addAll(
                new Label("Список продуктов"),
                foodListView,
                new Label("Добавить/Обновить продукт"),
                inputFields,
                actionButtons
        );

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cписок продуктов");
        primaryStage.show();
    }

    private void addFoodToRepository(FoodRepository repository) {
        Map<String, Double> appleNutritionalValue = Map.of("Белки", 0.5, "Жиры", 0.3, "Углеводы", 10.0);
        repository.addFood(new Fruit("Яблоко", true, appleNutritionalValue));
    }

    // Метод для округления и форматирования значений до 2 знаков после запятой
    public String formatDouble(double value) {
        return df.format(value);
    }

    // Метод для отображения предупреждений
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
