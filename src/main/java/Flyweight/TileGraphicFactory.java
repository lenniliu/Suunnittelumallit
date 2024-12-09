package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, TileGraphic> graphicCache = new HashMap<>();

    public static TileGraphic getGraphic(String tileType) {
        TileGraphic graphic = graphicCache.get(tileType);
        if (graphic == null) {
            // Create a new graphic if it doesn't exist
            switch (tileType) {
                case "grass":
                    graphic = new TileGraphic("images/grass.png");
                    break;
                case "water":
                    graphic = new TileGraphic("images/water.png");
                    break;
                case "mountain":
                    graphic = new TileGraphic("images/mountain.png");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown tile type: " + tileType);
            }
            graphicCache.put(tileType, graphic);
        }
        return graphic;
    }
}

