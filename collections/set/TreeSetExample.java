package collections.set;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/26/22
 */

//it is used to get subSet
//it uses comparator to sort values
//it uses self-balancing binary search tree to store elements
//it is faster than HashSet and Stack
public class TreeSetExample {
    public static void main(String[] args) {
        class Employee {
            private String name;

            public String getName() {
                return name;
            }

            Employee(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Employee)) return false;
                Employee employee = (Employee) o;
                return name.equals(employee.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name);
            }
        }

        Comparator<Employee> comparator = Comparator.comparing(Employee::getName);

            System.out.println("........tree set.......");
            TreeSet<Employee> sortedSet = new TreeSet<>(comparator);
            sortedSet.add(new Employee("Bikash"));
            sortedSet.add(new Employee("Apple"));
            sortedSet.add(new Employee("Indira"));
            sortedSet.add(new Employee("Bikki"));
            sortedSet.add(new Employee("Bipin"));
            sortedSet.add(new Employee("Bipin"));
            System.out.println(sortedSet);

            System.out.println(sortedSet);
            SortedSet<Employee> subSet = sortedSet.subSet(new Employee("Bikash"),new Employee("Indira"));
            System.out.println(subSet);
        }
    }

