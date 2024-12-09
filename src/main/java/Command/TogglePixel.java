package Command;

public class TogglePixel implements Command {
    private PixelArtGrid grid;

    public TogglePixel(PixelArtGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.togglePixel();
    }
}
