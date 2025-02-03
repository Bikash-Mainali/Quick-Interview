package LabOfLamdaStream.src.level2.Lab3_1.src;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {

       /* List<Position> positions1 = Arrays.asList(new Position("Software Engineer1", "Desc1"),
                new Position("Software Engineer2", "Desc2"),
                new Position("Software Engineer3", "Desc3"));
        List<Position> positions2 = Arrays.asList(new Position("Software Engineer1", "Desc1"),
                new Position("Software Engineer2", "Desc2"),
                new Position("Software Engineer3", "Desc3"));*/

        //position related to HR
        Position hPosition1 = new Position("HR Director", "Desc1");
        Position hPosition2 = new Position("Associate HR Manager", "Desc2");
        Position hPosition3 = new Position("HR Manager", "Desc3");


        //position related to R & D
        Position rPosition1 = new Position("Senior Software Engineer", "Desc4");
        Position rPosition2 = new Position("Engineering Manager", "Desc5");
        Position rPosition3 = new Position("Project Manager", "Desc6");

        Department department1 = new Department("HR Department", "1000 North 4th St");
        department1.addPosition(hPosition1);
        department1.addPosition(hPosition2);
        department1.addPosition(hPosition3);


        // TODO: 1/14/22 for lab3.3
        //for lab3.3
/*
        Position p1 = new Position("CEO", "Lyle", null);
        Position p2 = new Position("Sales Man1", "Anne", p1);
        Position p4 = new Position("Department Head", "Ron", p1);
        Position p5 = new Position("Sales Man3", "Peter", null);

        Position p6 = new Position("Sales Man4", "Dan", p5);
        Position p7 = new Position("Sales Man5", "Bill", p5);

        Position p8 = new Position("Sales Man6", "Stan", null);

        Position p9 = new Position("Sales Man7", "Marc", p8);
        Position p10 = new Position("Sales Man7", "Tom", p8);


        //new Position(hPosition3);
        Department mrDepartment = new Department("Marketing Department", "4000 North 4th St");
        mrDepartment.addPosition(p1);
        mrDepartment.addPosition(p2);
        mrDepartment.addPosition(p4);
        mrDepartment.addPosition(p5);
        mrDepartment.addPosition(p6);
        mrDepartment.addPosition(p7);
        mrDepartment.addPosition(p8);
        mrDepartment.addPosition(p9);
        mrDepartment.addPosition(p10);
        */


        Department department2 = new Department("R & D Department", "2000 North 4th St");
        department2.addPosition(rPosition1);
        department2.addPosition(rPosition2);
        department2.addPosition(rPosition3);

        Employee emp1 = new Employee("124", "John", null, "Hoover", LocalDate.of(1994, 1, 13), "12334", 3000);
        Employee emp2 = new Employee("125", "John", null, "Hanna", LocalDate.of(1995, 1, 13), "12335", 4000);
        Employee emp3 = new Employee("126", "Abby", null, "Abby", LocalDate.of(1996, 1, 13), "12336", 6000);

        hPosition1.addEmployee(emp1);
        hPosition2.addEmployee(emp2);
        rPosition3.addEmployee(emp3);

        List<Department> departments = Arrays.asList(department1, department2);

        Company company = new Company("GOOGLE", departments);

        //for lab 3.1
        company.print();

        //for lab 3.2
        company.getSalary();
    }
}
