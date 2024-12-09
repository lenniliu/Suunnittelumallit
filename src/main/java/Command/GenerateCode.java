package Command;

public class GenerateCode implements Command {
    private PixelArtGrid grid;

    public GenerateCode(PixelArtGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.generateCode();
    }
}
