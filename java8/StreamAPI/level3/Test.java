package java8.StreamAPI.level3;

import java8.StreamAPI.sorted.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/4/22
 */
public class Test {
    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(new Employee("ZZZZ", 4),
                new Employee("Biki", 5),
                new Employee("ZZZZ", 41));

        System.out.println(".......collecting list to map......");
        //collecting to map
        Map<Float, Employee> employeeMap = list.stream()
                .collect(Collectors.toMap(Employee::getSalary, x -> x)); // .toMap(Employee::getSalary, Function.identity()));
       /* NOTE:: NOTE: identity is a static method on Function that returns a function that always returns its input argument.
                In the example, it is the function (Employee e) -> e
                */

        System.out.println(employeeMap);

        System.out.println(".......collecting list to set......");
        Set<String> employeeNameSet = list.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(employeeNameSet);

        System.out.println(".......collecting list to tree set......");
        TreeSet<String> employeeNameTreeSet = list.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(employeeNameTreeSet);
    }
}
