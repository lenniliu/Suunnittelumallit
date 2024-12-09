package FactoryMethod;
import java.lang.String;

// Tile Interface
public interface Tile {
    char getCharacter(); // Returns the character representing the tile type
    String getType();    // Returns the name of the tile type
}

// Swamp Tile
class SwampTile implements Tile {
    public char getCharacter() {
        return 'S';
    }

    public String getType() {
        return "swamp";
    }
}

// Water Tile
class WaterTile implements Tile {
    public char getCharacter() {
        return 'W';
    }

    public String getType() {
        return "water";
    }
}

// Road Tile
class RoadTile implements Tile {
    public char getCharacter() {
        return 'R';
    }

    public String getType() {
        return "road";
    }
}

// Forest Tile
class ForestTile implements Tile {
    public char getCharacter() {
        return 'F';
    }

    public String getType() {
        return "forest";
    }
}

// Building Tile
class BuildingTile implements Tile {
    public char getCharacter() {
        return 'B';
    }

    public String getType() {
        return "building";
    }
}

