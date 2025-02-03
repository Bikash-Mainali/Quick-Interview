package java8.StreamAPI.collectingAndThen;

import photon.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 6/17/23
 */

//Given list of Tickers, find the latest price for each companyId in efficiently
class ComplexExample {
    public static void main(String[] args) {
        List<Ticker> tickerList = new ArrayList<>();
        tickerList.add(new Ticker(1, 100, 1623831331000L));
        tickerList.add(new Ticker(2, 200, 1623831332000L));
        tickerList.add(new Ticker(1, 110, 1623831333000L));
        tickerList.add(new Ticker(2, 220, 1623831334000L));
        tickerList.add(new Ticker(1, 120, 1623831335000L));

        Map<Integer, List<Ticker>> companyWiseTicker = tickerList.stream()
                .collect(Collectors.groupingBy(Ticker::getCompanyId, Collectors.toList()));


        System.out.println("\n.......First approach: Given list of Tickers, find the latest price for each companyId in efficiently......");
        Map<Integer, Ticker> companyWiseTicker1 = tickerList.stream()
                .collect(Collectors.toMap(
                        Ticker::getCompanyId,
                        ticker -> ticker,
                        (ticker1, ticker2) -> ticker1.getTimeStamp() > ticker2.getTimeStamp() ? ticker1 : ticker2)
                );
        companyWiseTicker1.forEach((companyId, ticker) -> {
            System.out.println("Company Id: " + companyId + " recent ticker is: " + ticker);
        });


        System.out.println("\n.......Second approach: Given list of Tickers, find the latest price for each companyId in efficiently......");
        Map<Integer, Ticker> companyWiseTicker2 = tickerList.stream()
                .collect(Collectors.groupingBy(
                        Ticker::getCompanyId,
                        Collectors.collectingAndThen(Collectors.toList(),
                                innerListByCompanyId -> {
                                    //return recent ticker
                                    Ticker tickerWithMaxTimeStamp = innerListByCompanyId.stream()
                                            .max(Comparator.comparing(Ticker::getTimeStamp)).orElse(null);
                                    return tickerWithMaxTimeStamp;
                                }
                        )));

        companyWiseTicker2.entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

        //group employee by department and sort the employee by salary
        Employee[] employees = {
                new Employee("Jason", "Red", 15, "IT"),
                new Employee("Ashley", "Green", 2, "IT"),
                new Employee("Matthew", "Ibadigo", 10, "Sales"),
                new Employee("James", "Iabdigo", 4, "Marketing"),
                new Employee("Luke", "Iaadigo", 5, "IT"),
                new Employee("Wendy", "Blue", 6, "Sales"),
                new Employee("Jason", "Blue", 436.4, "Marketing")
        };

        Map<String, List<Employee>> map = Arrays.stream(employees).collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        employeeList -> {
                            employeeList.sort(Comparator.comparing(Employee::getSalary));
                            //you can not do stream().sorted() here since it creates a new stream
                            return employeeList;
                        }
                )));
        System.out.println(map);
    }
}
