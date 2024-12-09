package Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PixelArtEditorApp extends Application {
    private PixelArtGrid grid;
    private PixelArtEditor editor;

    @Override
    public void start(Stage primaryStage) {
        grid = new PixelArtGrid();
        editor = new PixelArtEditor(grid);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);


        Rectangle[][] pixels = new Rectangle[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle pixel = new Rectangle(30, 30);
                pixel.setFill(grid.getPixel(x, y) == 1 ? Color.BLACK : Color.WHITE);
                pixel.setStroke(Color.GRAY);
                final int finalX = x;
                final int finalY = y;
                pixel.setOnMouseClicked(e -> {
                    grid.togglePixel();
                    pixel.setFill(grid.getPixel(finalX, finalY) == 1 ? Color.BLACK : Color.WHITE);
                });
                pixels[x][y] = pixel;
                gridPane.add(pixel, x, y);
            }
        }

        // Button to generate the code
        Button generateCodeButton = new Button("Generate Java Code");
        generateCodeButton.setOnAction(e -> editor.generateCode());

        // Event handler for keyboard input
        Scene scene = new Scene(gridPane, 300, 300);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) editor.moveUp();
            if (e.getCode() == KeyCode.DOWN) editor.moveDown();
            if (e.getCode() == KeyCode.LEFT) editor.moveLeft();
            if (e.getCode() == KeyCode.RIGHT) editor.moveRight();
            if (e.getCode() == KeyCode.SPACE) editor.togglePixel();
        });

        // Final layout
        gridPane.add(generateCodeButton, 0, 8, 8, 1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

