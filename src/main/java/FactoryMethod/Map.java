package FactoryMethod;

import java.util.Random;

abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        generateMap();
    }

    // Factory Method
    protected abstract Tile createTile();

    // Generate the map
    private void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    // Display the map
    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

// CityMap class
class CityMap extends Map {
    private static final Tile[] CITY_TILES = {
            new RoadTile(),
            new ForestTile(),
            new BuildingTile()
    };

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        Random random = new Random();
        return CITY_TILES[random.nextInt(CITY_TILES.length)];
    }
}

// WildernessMap class
class WildernessMap extends Map {
    private static final Tile[] WILDERNESS_TILES = {
            new SwampTile(),
            new WaterTile(),
            new ForestTile()
    };

    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        Random random = new Random();
        return WILDERNESS_TILES[random.nextInt(WILDERNESS_TILES.length)];
    }
}

