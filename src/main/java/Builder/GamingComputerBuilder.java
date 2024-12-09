package Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Ryzen 7 7800X3D");
    }

    @Override
    public void buildRAM() {
        computer.setRam(32);  // High RAM for gaming
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("4TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Radeon 7900 XTX");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 (Todellisuudessa huonoin windows versio pelaamiselle)");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}

