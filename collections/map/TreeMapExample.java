package collections.map;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */
// it is used to get subMap
// it uses comparator to sort values
public class TreeMapExample {
    public static void main(String[] args) {
        class Employee {
            private String name;
            private float salary;

            public String getName() {
                return name;
            }

            public float getSalary() {
                return salary;
            }

            Employee(String name, float salary) {
                this.name = name;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", salary=" + salary +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Employee)) return false;
                Employee employee = (Employee) o;
                return Float.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, salary);
            }
        }

        Comparator<Employee> comparator = (p1, p2) -> {
            if (p1.getSalary() > p2.getSalary()) return 1;
            if (p1.getSalary() < p2.getSalary()) return -1;
            else  return 0;
        };

        TreeMap<Employee, String> sortedMap = new TreeMap<>(comparator);
        sortedMap.put(new Employee("Bikash", 123), "aa");
        sortedMap.put(new Employee("Apple", 345345), "bb");
        sortedMap.put(new Employee("Indira", 100), "tt");
        sortedMap.put(new Employee("Bikki", 15), "cc");
        sortedMap.put(new Employee("Bipin", 123), "xc");
        System.out.println(sortedMap);

        SortedMap<Employee, String> subMap = sortedMap.subMap(new Employee("Indira", 100),new Employee("Apple", 345345));
        System.out.println(subMap);
    }
}
