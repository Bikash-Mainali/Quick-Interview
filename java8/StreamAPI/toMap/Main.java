package java8.StreamAPI.toMap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 11/13/23
 */
public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("Jason", "Red", 15, "IT"),
                new Employee("Ashley", "Green", 2, "IT"),
                new Employee("Matthew", "Ibadigo", 12, "Sales"),
                new Employee("James", "Iabdigo", 4, "Marketing"),
                new Employee("Luke", "Iaadigo", 5, "IT"),
                new Employee("Wendy", "Blue", 6, "Sales"),
                new Employee("Jason", "Blue", 436.4, "Marketing")};


        Map<Double, Employee> employeeMap = Arrays.stream(employees)
                .collect(Collectors.toMap(Employee::getSalary, x -> x)); // .toMap(Employee::getSalary, Function.identity()));


        //if employees have duplicate keys then should use mergeFunction as below
        Map<Double, Employee> employeeMap1 = Arrays.stream(employees)
                .collect(Collectors.toMap(Employee::getSalary, x->x, (existing, replacement) -> replacement));
        employeeMap1.forEach((salary, employee) -> {
            System.out.println(salary + " " + employee);
        });

        //convert to concurrentHashMap
        Map<Double, Employee> employeeMap2 = Arrays.stream(employees)
                .collect(Collectors.toMap(Employee::getSalary, x->x, (o1, o2) -> o1, ConcurrentHashMap::new));
        System.out.println(employeeMap2 instanceof ConcurrentHashMap);

        //sorted map (TreeMap by default sorts in alphabetical order)
        System.out.println("......sorted map......");
        Map<Double, Employee> employeeMap3 = Arrays.stream(employees)
                .collect(Collectors.toMap(Employee::getSalary, x->x, (o1, o2) -> o1, TreeMap::new));
        employeeMap3.forEach((salary, employee) -> {
            System.out.println(salary + " " + employee);
        });
    }
}
