package Flyweight;

import javafx.scene.canvas.GraphicsContext;

public class Map {
    private Tile[][] tiles;

    public Map(int width, int height) {
        tiles = new Tile[width][height];
        generateMap();
    }

    private void generateMap() {
        // Example map generation
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                // Create tiles randomly
                String type = (Math.random() < 0.5) ? "grass" : "water";
                tiles[i][j] = new Tile(type);
            }
        }
    }

    public void render(GraphicsContext gc) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].render(gc, i * 32, j * 32); // Render tile at the appropriate position
            }
        }
    }
}

