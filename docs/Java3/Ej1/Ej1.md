# Ejercico 1

## Primera parte

### 1º
- En las modificaciones anteriores, se utilizan las operaciones de Streams de Java 8 para reemplazar los bucles for-each y los condicionales.

1. getEmployeeByName utiliza stream() para convertir la lista de empleados en un stream y luego aplica el filtro para encontrar el empleado por nombre. Luego, findFirst() devuelve un Optional<Employee> que puede contener el resultado encontrado o estar vacío si no se encontró ningún empleado con el nombre especificado.
2. getEmployeeByNameAndAge sigue un enfoque similar al anterior, pero también compara la edad del empleado.
3. getEmployeeByAgeOver utiliza filter para obtener los empleados cuya edad sea mayor que el límite especificado y luego utiliza collect para convertir los elementos filtrados en una lista.
4. getEmployeeByAgeUnder sigue un enfoque similar, pero filtra los empleados cuya edad sea menor que el límite especificado.

- Estas modificaciones permiten aprovechar las características de la API de Streams de Java 8, como la concisión del código y la capacidad de realizar operaciones en paralelo si es necesario. 

### 2º

- Las extensiones agregan las siguientes operaciones a la clase EmployeeDatabase:

1. getEmployeesByAgeRange toma dos parámetros minAge y maxAge y devuelve una lista de empleados cuyas edades están dentro del rango especificado.
2. getEmployeesOrderedByAgeAsc devuelve una lista de empleados ordenados de manera ascendente según su edad.
3. getEmployeesOrderedByAgeDesc devuelve una lista de empleados ordenados de manera descendente según su edad.
4. getNumberOfEmployees devuelve el número total de empleados en la base de datos.
5. getNumberOfEmployeesWithName toma un parámetro name y devuelve el número de empleados en la base de datos cuyo nombre coincide con el valor proporcionado.

- Estas extensiones agregan funcionalidad adicional a la clase EmployeeDatabase para realizar operaciones más específicas sobre la base de datos de empleados.


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