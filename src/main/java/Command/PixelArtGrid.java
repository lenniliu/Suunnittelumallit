package Command;

public class PixelArtGrid {
    private int[][] grid;
    private int cursorX, cursorY;

    public PixelArtGrid() {
        grid = new int[8][8]; // 8x8 grid
        cursorX = 0;
        cursorY = 0;
    }

    public void moveCursorUp() {
        if (cursorY > 0) cursorY--;
    }

    public void moveCursorDown() {
        if (cursorY < 7) cursorY++;
    }

    public void moveCursorLeft() {
        if (cursorX > 0) cursorX--;
    }

    public void moveCursorRight() {
        if (cursorX < 7) cursorX++;
    }

    public void togglePixel() {
        grid[cursorY][cursorX] = (grid[cursorY][cursorX] == 1) ? 0 : 1;
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int i = 0; i < 8; i++) {
            System.out.print("    {");
            for (int j = 0; j < 8; j++) {
                System.out.print(grid[i][j]);
                if (j < 7) System.out.print(", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }

    public int getPixel(int x, int y) {
        return grid[y][x];
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }
}

