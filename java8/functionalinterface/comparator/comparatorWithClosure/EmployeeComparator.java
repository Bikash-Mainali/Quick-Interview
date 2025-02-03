package java8.functionalinterface.comparator.comparatorWithClosure;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/20/22
 */
public class EmployeeComparator {
    public enum SortMethod {
        BYSALARY, BYNAME
    }

    public static void sortWithClosure(List<Employee> list, SortMethod sortMethod) {
        Comparator<Employee> comparator = new  Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (sortMethod == SortMethod.BYNAME) {
                    return e1.getName().compareTo(e2.getName());
                } else {
                    if (e1.getSalary() > e2.getSalary()) {
                        return 1;
                    } else if (e1.getSalary() < e2.getSalary()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        };
        Collections.sort(list, comparator);
    }
}
