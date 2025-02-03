package LabOfLamdaStream.src.level2.Lab3_1.src;

import java.time.LocalDate;

public class Employee {
    private String employeeId;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private LocalDate birthDate;
    private String SSN;

    public Employee(String employeeId, String firstName, String middleInitial, String lastName, LocalDate birthDate, String SSN, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.SSN = SSN;
        this.salary = salary;
    }

    private double salary;

    public String getemployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSSN() {
        return SSN;
    }


    public String print() {
        return "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", SSN='" + SSN + '\'' +
                ", salary=" + salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee))
            return false;
        Employee e = (Employee) obj;
        boolean isEqual = this.employeeId == e.employeeId && this.firstName.equals(e.firstName);
        return isEqual;
    }

}
