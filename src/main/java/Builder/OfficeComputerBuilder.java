package Builder;

public class OfficeComputerBuilder implements ComputerBuilder{
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.setProcessor("Intel i5");
    }

    public void buildRAM() {
        computer.setRam(16);  // High RAM for office work
    }

    public void buildHardDrive() {
        computer.setHardDrive("512GB SSD");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }

    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10");
    }

    public Computer getComputer() {
        return this.computer;
    }
}
