package Flyweight;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Game extends Application {
    private Map map;

    @Override
    public void start(Stage primaryStage) {
        map = new Map(10, 10); // 10x10 map for demonstration

        Canvas canvas = new Canvas(320, 320); // 10x10 tiles, each 32x32
        GraphicsContext gc = canvas.getGraphicsContext2D();

        map.render(gc); // Render the map

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 320, 320);
        primaryStage.setTitle("RPG Map with Flyweight Pattern");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

