package LabOfLamdaStream.src.level2.Lab3_1.src;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String title;
    private String description;

    Employee employee;

    Position superior;
    List<Position> inferiors = new ArrayList<>();


    public Position(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // TODO: 1/14/22 for lab3.3 
    public Position(String title, String name, Position superior) {
        this.inferiors = new ArrayList<>();
        this.title = title;
        if (superior != null) {
            this.superior = superior;
            superior.inferiors.add(this);
        } else {
            this.superior = null;
        }
        if (superior != null) {
            superior.inferiors.forEach(x -> System.out.println(x.getTitle()));
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    void addEmployee(Employee e) {
        employee = e;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    String print() {
        StringBuilder result = new StringBuilder();
        result.append("\n\t\t\t");
        if (getEmployee() != null) {
            result.append(getEmployee().print());
        } else {
            result.append("no employee assigned");
        }
        return result.toString();
    }

    double getSalary() {
        if (getEmployee() != null)
            return getEmployee().getSalary();
        return 0;
    }

    void printDownLine() {

    }

}

