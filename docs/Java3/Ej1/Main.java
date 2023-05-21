package Java3.Ej1;

public class Main {
    public static void main(String args[]) {
        System.out.println("Employee = " +
          EmployeeDatabase.getEmployeeByName("Employee1"));
        System.out.println("Employee = " +
          EmployeeDatabase.getEmployeeByName("EmployeeNull"));
        System.out.println("Employee = " +
          EmployeeDatabase.getEmployeeByNameAndAge("Employee2", 30));
        System.out.println("Employee = " +
          EmployeeDatabase.getEmployeeByNameAndAge("Employee2", 20));
        System.out.println("Employees = " +
          EmployeeDatabase.getEmployeeByAgeOver(30));
        System.out.println("Employees = " +
          EmployeeDatabase.getEmployeeByAgeUnder(30));
    }
}