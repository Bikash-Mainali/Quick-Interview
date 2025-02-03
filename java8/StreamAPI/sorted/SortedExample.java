package java8.StreamAPI.sorted;

import java8.functionalinterface.comparator.comparatorWithClosure.EmployeeComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/22/22
 */
public class SortedExample {

    public enum SortMethod {
        SORTBYNAME,
        SORTBYSALARY
    }

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Bikash", 120),
                new Employee("Prakash", 110),
                new Employee("Bipin", 200),
                new Employee("Ray", 200),
                new Employee("Prabin", 200));
        //default sort in ascending order
        System.out.println("default sorted()");
        employeeList.stream().map(x -> x.getName()).sorted().forEach(System.out::println);

        //sorted() with comparator and compare by  NAME only
        System.out.println("sorted() with comparator and compare by  NAME only");
        employeeList.stream().sorted((e1, e2) -> {
            return e1.getName().compareTo(e2.getName());
        }).forEach(System.out::println);

        //sorted() with comparator and closure together
        System.out.println("sorted() with comparator and closure together");
        sortWithClosure(employeeList, SortMethod.SORTBYNAME);

        //more declarative way
        System.out.println("more declarative way");
        Function<Employee, String> byName = Employee::getName;
        employeeList.stream().sorted(Comparator.comparing(byName)).forEach(System.out::println);
        System.out.println("..........");

        //sorted in reversed order
        System.out.println("sorted in reversed order");
        Function<Employee, Float> bySalary = (x) -> x.getSalary();
        employeeList.stream().sorted(Comparator.comparing(bySalary).reversed()).forEach(System.out::println);

        //thenComparing()
        System.out.println("thenComparing()");
        employeeList.stream().sorted(Comparator.comparing(bySalary).thenComparing(byName)).forEach(System.out::println);


    }

    public static void sortWithClosure(List<Employee> list, SortMethod sortMethod) {
        //with comparator
        Comparator<Employee> comparator = (e1, e2) -> {
            if (sortMethod.equals(SortMethod.SORTBYNAME)) {
                return e1.getName().compareTo(e2.getName());
            } else {
                if (e1.getSalary() > e2.getSalary()) {
                    return 1;
                }
                if (e1.getSalary() < e2.getSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        list.stream().sorted(comparator).forEach(System.out::println);
    }

}
