package Builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        director.constructComputer();
        Computer gamingComputer = director.getComputer();
        System.out.println(gamingComputer);

        System.out.println("\n--------------------------\n");

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new ComputerDirector(officeBuilder);
        director.constructComputer();
        Computer officeComputer = director.getComputer();
        System.out.println(officeComputer);
    }
}

