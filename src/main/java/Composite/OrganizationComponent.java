package Composite;

import java.util.ArrayList;
import java.util.List;

abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public abstract double getSalary();
    public abstract void printStructure(StringBuilder xmlBuilder, int indent);
}

class Employee extends OrganizationComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printStructure(StringBuilder xmlBuilder, int indent) {
        xmlBuilder.append(" ".repeat(indent))
                .append("<Employee name=\"").append(name)
                .append("\" salary=\"").append(salary)
                .append("\" />\n");
    }
}

class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationComponent component : components) {
            totalSalary += component.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void printStructure(StringBuilder xmlBuilder, int indent) {
        xmlBuilder.append(" ".repeat(indent))
                .append("<Department name=\"").append(name)
                .append("\">\n");
        for (OrganizationComponent component : components) {
            component.printStructure(xmlBuilder, indent + 2);
        }
        xmlBuilder.append(" ".repeat(indent))
                .append("</Department>\n");
    }
}
