package IOObjectStream;

import java.io.Serializable;

public class Employee implements Serializable {
    private transient String name; //transient means name do not need to serialized
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name+" "+salary;
    }
}
