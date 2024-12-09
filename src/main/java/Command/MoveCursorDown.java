package Command;

public class MoveCursorDown implements Command {
    private PixelArtGrid grid;

    public MoveCursorDown(PixelArtGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorDown();
    }
}
