package java8.functionalinterface.comparable;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/20/22
 */


public class Employee implements Comparable<Employee> {
    private String name;
    private float salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        if (this.getSalary() < e.getSalary()) {
            return 1;
        }
        if (this.getSalary() == e.getSalary()) {
            return 0;
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
