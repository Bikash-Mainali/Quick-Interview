package LabOfLamdaStream.src.level2.Lab3_1.src;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Department {
    private String name;
    private String location;
    private List<Position> positions;


    Department(String name, String location) {
        this();
        this.name = name;
        this.location = location;
    }

    Department() {
        positions = new ArrayList<>();
    }

    void addPosition(Position p) {
        positions.add(p);
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return this.name + "|" + location;
    }

    public String getName() {
        return name;
    }

    String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getPositions().size(); i++) {
            int index = i;
            result.append("\n\t\t");
            result.append(index + 1 + ") " + getPositions().get(i).getTitle() + "(" + getPositions().get(i).getDescription() + ")");
            result.append(getPositions().get(i).print());
        }
        return result.toString();
    }

    double getSalary() {
        /*
        double result = 0.0;
        for (Position p : getPositions()) {
            result += p.getSalary();
        }
        return result;

         */

        DoubleSummaryStatistics ds = getPositions().stream()
                .mapToDouble(Position::getSalary).summaryStatistics();
        return ds.getSum();
    }

    void printReportingHierarchy() {

    }

    void printDepartmentHead() {

    }


}
