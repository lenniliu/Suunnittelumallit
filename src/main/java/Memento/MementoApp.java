package Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;

public class MementoApp extends Application {

    private Originator originator = new Originator();
    private Caretaker caretaker = new Caretaker();

    @Override
    public void start(Stage primaryStage) {
        // Initial state
        originator.setColor1("Red");
        originator.setColor2("Green");
        originator.setColor3("Blue");
        originator.setCheckboxState(false);
        caretaker.saveState(originator.saveStateToMemento());

        // UI elements
        TextField color1Field = new TextField("Red");
        TextField color2Field = new TextField("Green");
        TextField color3Field = new TextField("Blue");
        CheckBox checkbox = new CheckBox("Checked");
        Button undoButton = new Button("Undo");
        Button redoButton = new Button("Redo");
        Button showHistoryButton = new Button("Show History");

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(new Label("Color 1:"), color1Field,
                new Label("Color 2:"), color2Field,
                new Label("Color 3:"), color3Field, checkbox, undoButton, redoButton, showHistoryButton);

        // Undo
        undoButton.setOnAction(e -> {
            Memento currentState = originator.saveStateToMemento();
            Memento restoredState = caretaker.undo(currentState);
            originator.restoreStateFromMemento(restoredState);
            updateUI(color1Field, color2Field, color3Field, checkbox);
        });

        // Redo
        redoButton.setOnAction(e -> {
            Memento currentState = originator.saveStateToMemento();
            Memento restoredState = caretaker.redo(currentState);
            originator.restoreStateFromMemento(restoredState);
            updateUI(color1Field, color2Field, color3Field, checkbox);
        });

        // Show history
        showHistoryButton.setOnAction(e -> showHistoryWindow());

        // Scene setup
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Memento Pattern Example");
        primaryStage.show();
    }

    private void updateUI(TextField color1Field, TextField color2Field, TextField color3Field, CheckBox checkbox) {
        color1Field.setText(originator.getColor1());
        color2Field.setText(originator.getColor2());
        color3Field.setText(originator.getColor3());
        checkbox.setSelected(originator.isCheckboxState());
    }

    private void showHistoryWindow() {
        Stage historyStage = new Stage();
        ListView<String> historyList = new ListView<>();

        for (Memento memento : caretaker.getHistory()) {
            historyList.getItems().add(memento.toString());
        }

        historyList.setOnMouseClicked(e -> {
            int selectedIndex = historyList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                originator.restoreStateFromMemento(caretaker.getHistory().get(selectedIndex));
            }
        });

        Scene historyScene = new Scene(new VBox(historyList), 400, 300);
        historyStage.setScene(historyScene);
        historyStage.setTitle("History Window");
        historyStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

