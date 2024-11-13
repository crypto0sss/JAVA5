import repo.InMemoryNumberRepositoryImpl;
import repo.NumberRepository;
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

public class MainApp extends Application {

    private final NumberRepository repository = new InMemoryNumberRepositoryImpl();
    private final ObservableList<Integer> numberObservableList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<Integer> numberListView = new ListView<>(numberObservableList);
        numberListView.setPrefHeight(200);

        Spinner<Integer> numberSpinner = new Spinner<>(0, 10000, 0);
        numberSpinner.setEditable(true);

        Spinner<Integer> newNumberSpinner = new Spinner<>(0, 10000, 0);
        newNumberSpinner.setEditable(true);

        Button addButton = new Button("Добавить");
        addButton.setStyle("-fx-background-color: #673ab7; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-padding: 10px;");
        addButton.setOnAction(e -> {
            int number = numberSpinner.getValue();
            repository.add(number);
            numberObservableList.add(number);
            numberSpinner.getValueFactory().setValue(0);
        });

        Button deleteButton = new Button("Удалить");
        deleteButton.setStyle("-fx-background-color: #d32f2f; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-padding: 10px;");
        deleteButton.setOnAction(e -> {
            Integer selectedNumber = numberListView.getSelectionModel().getSelectedItem();
            if (selectedNumber != null) {
                repository.delete(selectedNumber);
                numberObservableList.remove(selectedNumber);
            }
        });

        Button updateButton = new Button("Обновить");
        updateButton.setStyle("-fx-background-color: #00796b; -fx-text-fill: #ffffff; -fx-font-size: 16px; -fx-padding: 10px;");
        updateButton.setOnAction(e -> {
            int oldNumber = numberSpinner.getValue();
            int newNumber = newNumberSpinner.getValue();
            repository.update(oldNumber, newNumber);

            numberObservableList.clear();
            for (int num : repository.getAll()) {
                numberObservableList.add(num);
            }
            numberSpinner.getValueFactory().setValue(0);
            newNumberSpinner.getValueFactory().setValue(0);
        });

        HBox inputFields = new HBox(10, new Label("Число:"), numberSpinner, new Label("Новое число:"), newNumberSpinner);
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
                new Label("Список чисел"),
                numberListView,
                new Label("Добавить/Обновить число"),
                inputFields,
                actionButtons
        );

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cписок чисел");
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
