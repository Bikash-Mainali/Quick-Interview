package java8.functionalinterface.comparator.comparatorWithClosure;

import java.util.Arrays;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/20/22
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("Bikash", 120), new Employee("Prakash", 110),
                new Employee("Bipin", 200));
        System.out.println("before sorting by name " + employeeList);
        EmployeeComparator.sortWithClosure(employeeList, EmployeeComparator.SortMethod.BYSALARY);
        System.out.println("after sorting by name " + employeeList);
    }
}
