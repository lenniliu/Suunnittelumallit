package Command;

public class MoveCursorLeft implements Command {
    private PixelArtGrid grid;

    public MoveCursorLeft(PixelArtGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorLeft();
    }
}
