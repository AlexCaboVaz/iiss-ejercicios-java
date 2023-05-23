package Java3.Ej1;
import Java3.Ej1.*;
public class Main{
    
  
    public static void main(String args[]) {
        System.out.println("Employee = " +
          EmployeeDataBase.getEmployeeByName("Employee1"));
        System.out.println("Employee = " +
          EmployeeDataBase.getEmployeeByName("EmployeeNull"));
        System.out.println("Employee = " +
          EmployeeDataBase.getEmployeeByNameAndAge("Employee2", 20));
        System.out.println("Employees = " +
          EmployeeDataBase.getEmployeeByAgeOver(30));
        System.out.println("Employees = " +
          EmployeeDataBase.getEmployeeByAgeUnder(30));
    }

}