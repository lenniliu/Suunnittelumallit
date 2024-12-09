package Command;

public class MoveCursorUp implements Command {
    private PixelArtGrid grid;

    public MoveCursorUp(PixelArtGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorUp();
    }
}
