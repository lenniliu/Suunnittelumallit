package Composite;

public class Main {
    public static void main(String[] args) {
        // Create departments
        Department root = new Department("Head Office");
        Department hrDepartment = new Department("HR Department");
        Department itDepartment = new Department("IT Department");

        // Add employees to HR
        hrDepartment.add(new Employee("Alice", 50000));
        hrDepartment.add(new Employee("Bob", 55000));

        // Add employees to IT
        itDepartment.add(new Employee("Charlie", 70000));
        itDepartment.add(new Employee("David", 75000));

        // Add departments to Head Office
        root.add(hrDepartment);
        root.add(itDepartment);

        // Add a standalone employee to Head Office
        root.add(new Employee("Eve", 80000));

        // Print total salary
        System.out.println("Total Salary: " + root.getSalary());

        // Print organizational structure in XML
        StringBuilder xmlBuilder = new StringBuilder();
        root.printStructure(xmlBuilder, 0);
        System.out.println("\nOrganizational Structure (XML):");
        System.out.println(xmlBuilder.toString());
    }
}

