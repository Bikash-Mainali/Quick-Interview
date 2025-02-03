package LabOfLamdaStream.src.level2.Lab3_1.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Company {
    private String name;
    private List<Department> departments;

    Company(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    void print() throws IOException {
        displayCompany();
        displayDepartment();

   /*// TODO: 1/13/22
          for user input choice
     *//*
        if (departments.size() != 0) {
            putText("Choose Department typing number: eg. 0 or 1 or 2");
            int choice = getKeyboardInput();
            if (choice < departments.size() && getPositionList(choice).size() != 0) {
                displayPositionByDepartment(choice);
                displayEmployeeByPosition(departments.get(choice).getPositions());
            } else {
                putText("invalid choice");
                print();  //recursive
            }
        }
*/
    }

    void displayCompany() {
        putText("Company Name: " + name);
        putText("");
    }

    void displayDepartment() {
        System.out.println("Departments:");
        for (int i = 0; i < departments.size(); i++) {
            StringBuilder result = new StringBuilder();
            result.append("\t");
            result.append(departments.get(i));
            result.append(departments.get(i).print());
            result.append("\n");
            System.out.println(result);
        }
    }

    /*// TODO: 1/13/22
          for user input choice
     */
/*
    void displayPositionByDepartment(int choice) throws IOException {
        switch (choice) {
            case 0:
                putText(departments.get(0).getName());
                for (int j = 0; j < getPositionList(choice).size(); j++) {
                    putText("\t" + j + "." + getPositionList(0).get(j).getTitle());
                }
                putText("Choose position typing number : eg. 0 or 1 or 2");
                break;
            case 1:
                putText(departments.get(1).getName());
                for (int j = 0; j < getPositionList(choice).size(); j++) {
                    putText("\t" + j + "." + departments.get(1).getPositions().get(j).getTitle());
                }
                putText("Choose position typing number : eg. 0 or 1 or 2");
                break;
            case 2:
                putText(departments.get(2).getName());
                for (int j = 0; j < getPositionList(choice).size(); j++) {
                    putText("\t" + j + "." + getPositionList(choice).get(j).getTitle());
                }
                putText("Choose position typing number : eg. 0 or 1 or 2");
                break;
            default:
        }
    }

    List<Position> getPositionList(int index) {
        return departments.get(index).getPositions();
    }

    void displayEmployeeByPosition(List<Position> positions) throws IOException {
        int choice = getKeyboardInput();
        switch (choice) {
            case 0:
            case 2:
            case 1:
                putText(positions.get(choice).getTitle());
                if (positions.get(choice).getEmployees().size() != 0) {
                    positions.get(choice).getEmployees().forEach(e -> putText("\t" + e.toString()));
                } else {
                    putText("\t No employee has been assigned to this position");
                }
                putText(":::::::::::::::::::::::::::");
                print();
                break;
            default:
                putText("No position is found!");
                print();
        }
    }
*/


    public static void putText(String s) {
        System.out.println(s);
    }

    /*// TODO: 1/13/22
       for user input choice
  */
    public static int getKeyboardInput() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        int s = Integer.parseInt(br.readLine());
        return s;
    }


    void getSalary() {
        /*
        double result = 0.0;
        for (Department d : departments) {
            result += d.getSalary();
        }
        System.out.println("Total salary is: " + result);
         */

        DoubleSummaryStatistics ds = departments.stream()
                .mapToDouble(Department::getSalary).summaryStatistics();
        System.out.println("Total salary is: " + ds.getSum());
    }
}
