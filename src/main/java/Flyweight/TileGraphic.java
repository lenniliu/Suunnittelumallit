package Flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TileGraphic {
    private String imagePath; // Path to the image or color representation

    public TileGraphic(String imagePath) {
        this.imagePath = imagePath;
    }

    public void render(GraphicsContext gc, double x, double y) {
        // In this case, we just use an image
        Image tileImage = new Image(imagePath);
        gc.drawImage(tileImage, x, y); // Renders the tile at the given coordinates
    }
}

