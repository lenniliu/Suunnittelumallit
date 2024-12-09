package Command;

public class MoveCursorRight implements Command {
    private PixelArtGrid grid;

    public MoveCursorRight(PixelArtGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorRight();
    }
}
