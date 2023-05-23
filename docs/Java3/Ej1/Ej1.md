# Ejercico 1

## Primera parte

### 1º
- En las modificaciones, hemos utilizado las operaciones de Stream de Java 8 para simplificar el código:

1. getEmployeeByName ahora devuelve un Optional<Employee>. Utilizamos stream() para convertir la lista de empleados en un flujo, luego usamos filter() para encontrar el empleado con el nombre dado y findFirst() para obtener el primer empleado que coincida.
2. getEmployeeByNameAndAge también devuelve un Optional<Employee>. Aplicamos las mismas operaciones que en getEmployeeByName, pero además verificamos si la edad del empleado coincide con el parámetro age.
3. getEmployeeByAgeOver ahora devuelve una lista de empleados utilizando toList(). Utilizamos stream() para convertir la lista de empleados en un flujo, luego aplicamos filter() para encontrar los empleados cuya edad sea mayor que el límite especificado.
4. getEmployeeByAgeUnder también devuelve una lista de empleados utilizando toList(). Aplicamos las mismas operaciones que en getEmployeeByAgeOver, pero verificamos si la edad del empleado es menor que el límite especificado.


```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                .toList();
    }

    public static List<Employee> getEmployeeByAgeUnder(int limitAge) {
        return employees.stream()
                .filter(e -> e.getAge() < limitAge)
                .toList();
    }
}
```

- Recuerda importar java.util.Optional y java.util.stream para poder utilizar estas operaciones. 

### 2º

- Ahora puedes utilizar las siguientes operaciones adicionales:

1. getEmployeesByAgeRange(int minAge, int maxAge): Esta operación devuelve una lista de empleados cuyas edades están comprendidas entre el rango dado por minAge y maxAge. Utilizamos filter() para seleccionar los empleados que cumplen con el criterio y toList() para convertir el flujo de empleados en una lista.

2. getEmployeesSortedByAgeAscending(): Esta operación devuelve una lista de empleados ordenados en orden ascendente según su edad. Utilizamos sorted() con Comparator.comparingInt() para ordenar los empleados por su edad y toList() para obtener la lista resultante.

3. getEmployeesSortedByAgeDescending(): Esta operación devuelve una lista de empleados ordenados en orden descendente según su edad. Utilizamos sorted() con Comparator.comparingInt().reversed() para ordenar los empleados en orden descendente por su edad y toList() para obtener la lista resultante.

5. getNumberOfEmployees(): Esta operación devuelve el número de empleados que existen en la base de datos utilizando el tamaño de la lista de empleados (employees.size()).

6. getNumberOfEmployeesWithName(String name): Esta operación devuelve el número de empleados que existen en la base de datos y cuyo nombre es igual al proporcionado como parámetro. Utilizamos filter() para seleccionar los empleados con el nombre dado y luego contamos la cantidad resultante utilizando count().

```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
                .toList();
    }

    public static List<Employee> getEmployeeByAgeUnder(int limitAge) {
        return employees.stream()
                .filter(e -> e.getAge() < limitAge)
                .toList();
    }

    public static List<Employee> getEmployeesByAgeRange(int minAge, int maxAge) {
        return employees.stream()
                .filter(e -> e.getAge() >= minAge && e.getAge() <= maxAge)
                .toList();
    }

    public static List<Employee> getEmployeesSortedByAgeAscending() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .toList();
    }

    public static List<Employee> getEmployeesSortedByAgeDescending() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .toList();
    }

    public static int getNumberOfEmployees() {
        return employees.size();
    }

    public static int getNumberOfEmployeesWithName(String name) {
        return (int) employees.stream()
                .filter(e -> e.getName().equals(name))
                .count();
    }
}
```




## Segunda Parte

### Clase VideoGame
- En la clase Videogame, se definen los siguientes atributos:

1. title de tipo String, que representa el título del videojuego.
2. category de tipo String, que representa la categoría del videojuego.
3. price de tipo double, que representa el precio del videojuego.

- Luego, se implementan los métodos getter y setter correspondientes para acceder a los atributos de la clase.

### Clase VideoGameDataBase

- En esta implementación, la clase VideogameDatabase tiene una lista de videojuegos (videogames) y proporciona métodos para realizar diversas operaciones utilizando el Stream API de Java 8. Cada método realiza una operación específica, como obtener títulos, filtrar por precio o categoría, ordenar, agrupar y calcular sumas.

- Puedes utilizar esta clase VideogameDatabase para realizar las operaciones requeridas en tu programa principal. Asegúrate de crear instancias de objetos Videogame y agregarlos a la base de datos antes de llamar a los métodos de la clase VideogameDatabase.

### Main Prueba

- Este programa de prueba crea una instancia de VideogameDatabase, agrega algunos videojuegos a la base de datos y luego realiza las operaciones requeridas utilizando los métodos de la clase VideogameDatabase. Cada operación se imprime en la consola para mostrar los resultados.

- Asegúrate de tener ambas clases, Videogame y VideogameDatabase, en tu proyecto y ejecuta el programa Main para ver los resultados de las operaciones.