package Java3.Ej1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDatabase {

    private static List<Employee> employees = Arrays.asList(
            new Employee("Employee1", 20),
            new Employee("Employee2", 30),
            new Employee("Employee3", 40),
            new Employee("Employee4", 50));

    public static Optional<Employee> getEmployeeByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst();
    }

    public static Optional<Employee> getEmployeeByNameAndAge(String name, int age) {
        return employees.stream()
                .filter(e -> e.getName().equals(name) && e.getAge() == age)
                .findFirst();
    }

    public static List<Employee> getEmployeeByAgeOver(int limitAge) {
        return employees.stream()
                .filter(e -> e.getAge() > limitAge)
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeeByAgeUnder(int limitAge) {
        return employees.stream()
                .filter(e -> e.getAge() < limitAge)
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesByAgeRange(int minAge, int maxAge) {
        return employees.stream()
                .filter(e -> e.getAge() >= minAge && e.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesOrderedByAgeAsc() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesOrderedByAgeDesc() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(Collectors.toList());
    }

    public static int getNumberOfEmployees() {
        return employees.size();
    }

    public static long getNumberOfEmployeesWithName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equals(name))
                .count();
    }
}
