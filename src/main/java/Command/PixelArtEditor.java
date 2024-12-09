package Command;

public class PixelArtEditor {
    private Command moveUpCommand, moveDownCommand, moveLeftCommand, moveRightCommand, togglePixelCommand, generateCodeCommand;

    public PixelArtEditor(PixelArtGrid grid) {
        moveUpCommand = new MoveCursorUp(grid);
        moveDownCommand = new MoveCursorDown(grid);
        moveLeftCommand = new MoveCursorLeft(grid);
        moveRightCommand = new MoveCursorRight(grid);
        togglePixelCommand = new TogglePixel(grid);
        generateCodeCommand = new GenerateCode(grid);
    }

    public void moveUp() {
        moveUpCommand.execute();
    }

    public void moveDown() {
        moveDownCommand.execute();
    }

    public void moveLeft() {
        moveLeftCommand.execute();
    }

    public void moveRight() {
        moveRightCommand.execute();
    }

    public void togglePixel() {
        togglePixelCommand.execute();
    }

    public void generateCode() {
        generateCodeCommand.execute();
    }
}

