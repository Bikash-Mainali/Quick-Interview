package LabOfLamdaStream.src;
// Program 4: ProcessingEmployees.java
// Processing streams of Employee objects.

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProcessingEmployees {
    public static void main(String[] args) {
        // initialize array of Employees
        Employee[] employees = {
                new Employee("Jason", "Red", 15, "IT"),
                new Employee("Ashley", "Green", 2, "IT"),
                new Employee("Matthew", "Ibadigo", 10, "Sales"),
                new Employee("James", "Iabdigo", 4, "Marketing"),
                new Employee("Luke", "Iaadigo", 5, "IT"),
                new Employee("Wendy", "Blue", 6, "Sales"),
                new Employee("Jason", "Blue", 436.4, "Marketing")};



        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);   //A method reference.


        // Predicate (boolean-valued function) that returns true for salaries
        //in the range $4000-$6000
        Predicate<Employee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        // Display Employees with salaries in the range $4000-$6000
        // sorted into ascending order by salary
        System.out.printf(
                "%nEmployees earning $4000-$6000 per month sorted by salary:%n");

        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);


        // Display first Employee with salary in the range $4000-$6000
        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get());

        // Functions for getting first and last names from an Employee
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = employee -> employee.getLastName();

        // Comparator for comparing Employees by first name then last name
        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        // sort employees by last name, then first name
        System.out.printf(
                "%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // sort employees in descending order by last name, then first name
        System.out.printf(
                "%nEmployees in descending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        // display unique employee last names sorted
        System.out.printf("%nUnique employee last names:%n");
        list.stream()
                .map(Employee::getLastName)
                .distinct()
                .sorted()
                .forEach(System.out::println);


        // display only first and last names
        System.out.printf(
                "%nEmployee names in order by last name then first name:%n");
        list.stream()
                .sorted(lastThenFirst)
                .map(Employee::getName)
                .forEach(System.out::println);


/**********************************************  LEVEL 3   ****************************************************************/
/*
        System.out.printf("strings greater than m sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(x -> x.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));
        Stream<Boolean> booleanStream = IntStream
                .range(0, booleans.length)
                .mapToObj(x -> booleans[x]);
*/

        Map<String, List<Employee>> groupedByDepartment =
                list.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        /**
         * 7 a) Level 3 :  Study  ‘Program 4’  of the file I gave you, of complete Java 8 programs.
         */
        System.out.printf("%nAverage salary by department......%n");
        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    DoubleSummaryStatistics ds = employeesInDepartment.stream().mapToDouble(e -> e.getSalary()).summaryStatistics();
                    System.out.printf("%-12s", department);
                    System.out.printf("%s%n", ds.getAverage());
                }
        );

        groupedByDepartment.entrySet().stream().forEach(x -> {
            System.out.println(x.getKey() + " --> " + x.getValue().stream().mapToDouble(y -> y.getSalary()).average().getAsDouble());
        });

        System.out.println("sum of salary by department........");
        groupedByDepartment.forEach((department, employeesInDepartment) -> {
            System.out.println(department + ": " + employeesInDepartment.stream().mapToDouble(e -> e.getSalary()).sum());
            //OR
            // System.out.println(department + ": "+employeesInDepartment.stream().mapToDouble(e -> e.getSalary()).reduce(0, (a, b) -> a + b));
        });

        /**
         * 7 b) Level 3 :  Study  ‘Program 4’  of the file I gave you, of complete Java 8 programs.
         */
        System.out.printf("%nMaximum salary by department......%n");
        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    DoubleSummaryStatistics ds = employeesInDepartment.stream().mapToDouble(e -> e.getSalary()).summaryStatistics();
                    System.out.printf("%-12s", department);
                    System.out.printf("%s%n", ds.getMax());
                }
        );

        // OR
        groupedByDepartment.entrySet().forEach(x -> {
            System.out.println(x.getKey() + "...." + x.getValue().stream().mapToDouble(y -> y.getSalary()).max().getAsDouble());
        });

        // group Employees by department
        /**
         * 7 c ) Level 3 :  Study  ‘Program 4’  of the file I gave you, of complete Java 8 programs.
         */
        System.out.printf("%nEmployees by department.... %n");
        groupedByDepartment.forEach(
                (department, employeesInDepartment) ->
                {
                    System.out.println(department);
                    employeesInDepartment.stream().forEach(
                            employee -> System.out.printf("   %s%n", employee));
                }
        );


        // count number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");

        Map<String, Long> employeeCountByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));

        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf(
                        "%s has %d employee(s)%n", department, count));

        //OR
        System.out.println("bbbbbbbbbbb");
        groupedByDepartment.forEach((department, employeesInDep) ->
                System.out.println(department + " has " + employeesInDep.stream().count() + "employee(s)"));

/*  Output looks something like :

        HR  4
        IT  8
        Sales  12
*/


        // sum of Employee salaries with DoubleStream sum method
        System.out.printf(
                "%nSum of Employees' salaries (via sum method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum());

        // calculate sum of Employee salaries with Stream reduce method
        System.out.printf(
                "Sum of Employees' salaries (via reduce method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .reduce(0, (value1, value2) -> value1 + value2));

        // average of Employee salaries with DoubleStream average method
        System.out.printf("Average of Employees' salaries: %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble());

/**********************************************  End of LEVEL 3   ****************************************************************/


/**************************************************   LEVEL 1  Question 2 (a)  ************************************************************/

        /**
         1)  Count the number of last names that begin with the letter  ‘B’.  Print out this number.
         */

        System.out.printf(" %n1)  Count the number of last names that begin with the letter  ‘B’.  Print out this number.");
        Predicate<Employee> startsWithB = e -> e.getLastName().startsWith("B");
        long countStartingWithB = list.stream()
                .filter(startsWithB)
                .count();

        System.out.printf("Count the number of last names that begin with the letter  ‘B’ %n: " + countStartingWithB);

        /**
         * 2)  Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.
         */

        System.out.printf(" %n2) Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order%n");
        list.stream()
                .filter(e -> e.getLastName().startsWith("B"))
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

        System.out.printf(" %n2) Print out all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order%n");
        list.stream()
                .filter(e -> e.getLastName().startsWith("B"))
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName).reversed())
                .forEach(System.out::println);


        /**
         *  3)  Print out all of the Employee objects whose last name begins with the letter  ‘B’  and change their
         *         first name and last name to be All capital letters.
         */

        System.out.printf(" %n3) Print out all of the Employee objects whose last name first name and last name to be All capital letters.%n");

        list.stream()
                .filter(e -> e.getLastName().charAt(0) == 'B')  // filter(e -> e.getLastName().startsWith("B))
                .map(e -> new Employee(e.getFirstName().toUpperCase(), e.getLastName().toUpperCase(), e.getSalary(), e.getDepartment()))
                .forEach(System.out::println);
        //OR
        list.stream()
                .filter(e -> e.getLastName().charAt(0) == 'B')  // filter(e -> e.getLastName().startsWith("B))
                .forEach(emp -> System.out.println(String.format("%-9s %-9s %-9.2f %s",
                        emp.getFirstName().toUpperCase(), emp.getLastName().toUpperCase(), emp.getSalary(), emp.getDepartment())));

        /**
         4)  Print out All of the employee objects, but if the last name begins with the letter  ‘B’,
         then capitalize all the letters in the last name.
         */

        System.out.printf("%n4) Print out All of the employee objects, but if the last name begins with the letter  ‘B’ then capitalize all the letters in the last name.%n");

        list.stream()
                .forEach(emp -> {
                    System.out.println(emp.getLastName().startsWith("B") ? emp.getFirstName() + " " + emp.getLastName().toUpperCase() + " " + emp.getSalary() + " " + emp.getDepartment() : emp);
                });

        //OR
        list.stream()
                .map(e ->
                        e.getLastName().startsWith("B") ? new Employee(e.getFirstName(), e.getLastName().toUpperCase(), e.getSalary(), e.getDepartment()) : e)
                .forEach(System.out::println);


        /** 4.1)  Use the  Collectors.joining  method to print out All Employee objects.  (See my  presentation file
         ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)
         */
        System.out.printf(" %n4.1)  Use the  Collectors.joining  method to print out All Employee objects.  (See my  presentation file ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)%n");

        String employeeString = list.stream()
                .map(Employee::toString)
                .collect(Collectors.joining(", "));
        System.out.println(employeeString);


        /**
         * 4.2)  Use the  Collectors.joining  method to print out All Employee objects, and separate    each one with a delimeter of
         *         “---\n---“.    (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)
         */
        System.out.printf("%n4.2)  Use the  Collectors.joining  method to print out All Employee objects, and separate each one with a delimeter of “---\\n---“.    (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)%n");
        String employeeString1 = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining("---\n---"));
        System.out.println(employeeString1);

        //extra
        System.out.printf("%nExtra   Use the  Collectors.joining  method to print out All Employee objects, and separate each one with a delimeter of “---\\n---“.    (See my  presentation file  ‘Do_Last_This_Was_Lesson 9_Streams_E.docx’.)%n");
        String empString = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(empString);


        /**
         *  5)  Print out all of the Employee objects’ last names, whose last name begins with the letter  ‘I’  in sorted
         *  order, and get rid of all the duplicates.  Print out only the last names.
         */

        System.out.printf("%n5)  Print out all of the Employee objects’ last names, whose last name begins with the letter  ‘I’  in sorted \n" +
                " order, and get rid of all the duplicates.  Print out only the last names.%n");
        list.stream()
                .filter(emp -> emp.getLastName().startsWith("I"))
                .map(emp -> {
                    return emp.getLastName();
                })
                .distinct()
                .sorted()
                .forEach(System.out::println);


        /**
         *  6. Print out the average of all the salaries.
         */

        System.out.printf(" %n6) Print out the average of all the salaries.%n");
        DoubleSummaryStatistics salaryStream = list.stream()
                .map(emp -> emp.getSalary())
                .collect(Collectors.summarizingDouble(Double::doubleValue)); // x -> s.doubleValue()
        System.out.println(salaryStream.getAverage());

        //OR
        DoubleStream doubleStream = list.stream()
                .mapToDouble(Employee::getSalary);
        double averageSalary = doubleStream
                .average()
                .getAsDouble();
        System.out.println("alternative1 : verage salary with different method: " + averageSalary);

        //OR
        DoubleSummaryStatistics ds = list.stream()
                .mapToDouble(emp -> emp.getSalary())
                .summaryStatistics();
        System.out.println("alternative2 : average salary with different method: " + ds.getAverage());


        /**
         * 7)  Use the  ‘reduce’  method to print out the total salary of all employees.
         */

        System.out.printf("%n7)  Use the  ‘reduce’  method to print out the total salary of all employees.%n");
        double totalSalary = list.stream()
                .mapToDouble(emp -> emp.getSalary())
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalSalary);

        /**
         * 8)  Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish this.
         */
        System.out.printf("%n8)  Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish this.  %n");
        list.stream()
                .map(emp -> emp.getFirstName())
                .forEach(System.out::println);


        /**
         * 9)  Create an infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only the first 20 even
         * numbers from this stream.
         */

        System.out.printf(" %n9)  Create an infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only the " +
                "first 20 even numbers from this stream. %n ");
        IntStream evenNumbers = IntStream.iterate(0, n -> n + 2).limit(40);
        evenNumbers.limit(20).forEach(n -> System.out.printf("%d", n));

        //generate
        Stream.generate(() -> "echo").limit(10).forEach(System.out::println);

        /**
         * 3) a) Implement  a method with the following signature and return type:
         */
        List<String> testList = new ArrayList<>() {{
            add("bikshw");
            add("ramesh");
            add("cat");
            add("carpet");
            add("carrot");
            add("camels");
        }};

        ProcessingEmployees p = new ProcessingEmployees();
        System.out.printf("%n3 a)Total number of strings with c and without d is: %d %n ", p.countWords(testList, 'b', 'a', 6));


        /**
         * 3 b)  Use reduce to concatenate the Strings in the Stream below to form a single, space-separated String.
         * Print the result to the console.
         */
        Stream strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
        System.out.printf("%n3 b) %s %n", strings.reduce((a, b) -> a + " " + b).orElse(null));


        /**
         * 3 c)  The many Java standard methods that are in the files I gave you; create programs to use  them and make sure
         * the results are correct!  (For example, test findfirst, findany, the Optional object (use generics here), orElse
         * inside an Optional, and others …
         */
        System.out.printf("%n3 c)  The many Java standard methods that are in the files I gave you; create programs to use  them and make sure\n" +
                "the results are correct!  (For example, test findfirst, findany, the Optional object (use generics here), orElse " +
                "inside an Optional, and others%n");
        System.out.printf("first employee: %s%n",
                list.stream()
                        .findFirst()
                        .get());

        System.out.printf("find any employee %s %n",
                list.stream()
                        .findAny()
                        .get());


        System.out.println(".......collecting list to array......");
        String[] employeeNameArray = list.stream()
                .map(Employee::getName)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(employeeNameArray));


        System.out.println(".......collecting list to map......");
        //collecting to map
        Map<Double, Employee> employeeMap = list.stream()
                .collect(Collectors.toMap(Employee::getSalary, x -> x)); // .toMap(Employee::getSalary, Function.identity()));
       /* NOTE:: NOTE: identity is a static method on Function that returns a function that always returns its input argument.
                In the example, it is the function (Employee e) -> e
                */

        List<String> l = Arrays.asList(
                "hello", "bye", "ciao", "bye", "ciao");
        Map<String, Long> counts = l.stream().
        collect(Collectors.groupingBy( w -> w, Collectors.counting()));
        System.out.println(counts.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(String::valueOf).collect(Collectors.joining(", ","{", "}")));


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




/**********************************************  End of Level 1 (Level 3 is in different package)   ****************************************************************/


    } // end main


    /*
public int countWords(List<String> words, char c, char d, int len)
which counts the number of words in the input list words that have length equal to len, that contain
the character c, and that do not contain the character d.  Create a solution that uses a lambda expression.
Hint :  Look at ALL of the methods that are available in the String class.  This will make it easier for you.
     */
    public int countWords(List<String> words, char c, char d, int len) {

        //eachString.contains(String.valueOf('c'))
        Predicate<String> predicate = eachString -> eachString.contains(String.valueOf(c)) && !eachString.contains(String.valueOf(d)) && eachString.length() == len;
        //OR
        //Predicate<String> predicate = eachString -> eachString.indexOf(c) >= 0 && eachString.indexOf(d) < 0 && eachString.length() == len;
        long count = words.stream()
                .filter(predicate)
                .count();
        return (int) count;
    }


} // end class ProcessingEmployees

