package Flyweight;

import javafx.scene.canvas.GraphicsContext;

public class Tile {
    private String type; // For example: "grass", "water", "mountain"
    private TileGraphic graphic; // Intrinsic state shared across tiles

    public Tile(String type) {
        this.type = type;
        this.graphic = TileGraphicFactory.getGraphic(type); // Fetches shared graphic from factory
    }

    public String getType() {
        return type;
    }

    public TileGraphic getGraphic() {
        return graphic;
    }

    // Extra state - position of the tile (extrinsic)
    public void render(GraphicsContext gc, double x, double y) {
        graphic.render(gc, x, y);
    }
}

