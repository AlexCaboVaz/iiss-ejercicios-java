# Ejercicios 

## Ejercicio 1

### ¿Existe algún tipo de problema en la implementación anterior de los que se incluye en la lista anterior? ¿Es necesario aplicar refactoring en este caso? En el caso de que existan problemas, indique cuáles son y qué tipos de problemas piensa que generarían en el futuro si no se aplica el refactoring ahora.

- Código duplicado: El proceso de capitalización de los nombres de usuario se realiza mediante un bucle y una lista temporal. Este código puede simplificarse utilizando el método map de Stream para realizar la transformación directamente en la lista original.

- Bucles demasiado largos o demasiado anidados: Aunque no hay bucles anidados, el proceso de capitalización de los nombres se realiza en dos pasos separados: primero se ordena la lista y luego se capitaliza. Esto podría combinarse en un solo bucle para mejorar la eficiencia y la legibilidad del código.

- Se usan comentarios para explicar código difícil de entender: Si bien no hay comentarios en la implementación actual, sería útil agregar comentarios para explicar la lógica detrás de las operaciones, especialmente si hay partes del código que pueden no ser inmediatamente comprensibles.

- Se usan variables globales: La variable usersWithPoints está declarada como una variable privada de la clase, lo cual es apropiado. Sin embargo, también podría hacerse final para indicar que no se modificará después de la inicialización.

- Los cambios dentro de una clase tienden a afectar a otras clases: No hay indicios de que los cambios en esta clase afecten a otras clases en este contexto específico. Sin embargo, si la clase se utiliza en otros lugares y se realizan cambios, podría afectar a las dependencias externas.

- En resumen, la implementación dada tiene algunos problemas que podrían beneficiarse de un refactoring para mejorar la legibilidad y la eficiencia del código. Los problemas identificados incluyen código duplicado, bucles separados para ordenar y capitalizar, falta de comentarios y variables globales. Es importante abordar estos problemas para mantener un código más limpio y fácil de mantener en el futuro.

### En el caso de que la implementación necesite la aplicación de refactoring, realice los cambios oportunos e indique las mejoras que aporta su implementación respecto a la original.
```
import java.util.*;

public class GroupOfUsers {

    private static final Map<String, Integer> usersWithPoints = new HashMap<String, Integer>() {{
        put("User1", 800);
        put("User2", 550);
        put("User3", 20);
        put("User4", 300);
    }};

    public List<String> getCapitalizedUsers() {
        List<String> users = new ArrayList<>(usersWithPoints.keySet());

        // Ordenar usuarios por puntos
        users.sort(Comparator.comparingInt(usersWithPoints::get).reversed());

        // Capitalizar los nombres de usuario
        users.replaceAll(String::toUpperCase);

        return users;
    }

    public static void main(String[] args) {
        GroupOfUsers group = new GroupOfUsers();
        List<String> users = group.getCapitalizedUsers();
        System.out.println("Los usuarios son: " + users);
    }
}
```
En esta versión refactorizada, se han realizado los siguientes cambios:

Se utiliza el método sort de la lista users en lugar de Stream para ordenar los usuarios directamente. Esto simplifica el código y mejora la eficiencia.

El proceso de capitalización se realiza utilizando el método replaceAll de la lista users, que toma una función como argumento. En este caso, se utiliza String::toUpperCase para capitalizar cada nombre de usuario de forma más concisa.

Se ha agregado la palabra clave final a la declaración de la variable usersWithPoints para indicar que no se modificará después de la inicialización.

Los comentarios adecuados se agregan para explicar la lógica detrás de las operaciones realizadas.

Con estos cambios, el código es más claro, conciso y eficiente, abordando los problemas mencionados anteriormente.


## Ejercicio 2

### El software del ejercicio anterior ha evolucionado añadiendo nueva funcionalidad en su implementación. ¿Existe algún tipo de problema en esta versión de la implementación de los que se incluyen en la lista? ¿Es necesario aplicar refactoring en este caso? En el caso de que existan problemas, indique cuáles son y qué tipos de problemas piensa que generarían en el futuro si no se aplica el refactoring ahora.

En la versión actual de la implementación, hay algunos problemas y oportunidades de mejora que podrían beneficiarse de un refactoring. Estos son algunos de los problemas identificados:

- Uso ineficiente de la memoria: En lugar de almacenar los nombres de usuario en tres listas diferentes (users1, users2, users3), sería más eficiente tener una sola lista de usuarios ordenados y capitalizados. Esto evitaría la duplicación de datos y reduciría el consumo de memoria.

- Uso incorrecto de tipos de datos: La variable users se declara como List<ArrayList<String>>, pero en realidad se puede declarar como List<List<String>> ya que no hay ninguna necesidad específica de usar ArrayList en este caso.

- Falta de encapsulamiento: Los mapas usersWithPoints_Group1, usersWithPoints_Group2 y usersWithPoints_Group3 se declaran como privados, pero no hay métodos para acceder a ellos o modificarlos. Esto limita la flexibilidad y hace difícil extender o modificar la funcionalidad de la clase en el futuro.

- Nombres de variables poco descriptivos: Los nombres de las variables en el código actual no son muy descriptivos y pueden dificultar la comprensión del código. Sería recomendable utilizar nombres más claros y significativos para mejorar la legibilidad y mantenibilidad del código.

- Falta de modularidad: El código actual realiza todas las operaciones en un solo método (getUsers). Sería más modular dividir las diferentes operaciones en métodos separados, lo que facilitaría la comprensión y el mantenimiento del código.

- Potencial falta de flexibilidad: El código actual está diseñado específicamente para tres grupos de usuarios. Si en el futuro se requiere agregar más grupos o cambiar la cantidad de grupos, el código requeriría modificaciones significativas. Sería deseable tener un diseño más flexible y adaptable para futuros cambios.

En resumen, aunque el código actual funciona, presenta algunos problemas y oportunidades de mejora que podrían abordarse mediante un refactoring. Un refactoring adecuado mejoraría la legibilidad, mantenibilidad y eficiencia del código, y permitiría una mayor flexibilidad para futuras modificaciones y extensiones.

### En el caso de que la implementación necesite la aplicación de refactoring, realice los cambios oportunos e indique las mejoras que aporta su implementación respecto a la original.

```
public class GroupOfUsers {
    
    private static final Map<String, Integer> usersWithPoints_Group1 =
      Map.of("User1", 800,
             "User2", 550,
             "User3", 20,
             "User4", 300);
    
    private static final Map<String, Integer> usersWithPoints_Group2 =
      Map.of("User1", 10,
             "User2", 990,
             "User3", 760,
             "User4", 230);
    
    private static final Map<String, Integer> usersWithPoints_Group3 =
      Map.of("User1", 1000,
             "User2", 200,
             "User3", 5,
             "User4", 780);
    
    public List<List<String>> getUsers() {
        List<List<String>> users = new ArrayList<>();
        
        users.add(getSortedAndCapitalizedUsers(usersWithPoints_Group1));
        users.add(getSortedAndCapitalizedUsers(usersWithPoints_Group2));
        users.add(getSortedAndCapitalizedUsers(usersWithPoints_Group3));
        
        return users;
    }
    
    private List<String> getSortedAndCapitalizedUsers(Map<String, Integer> usersWithPoints) {
        return usersWithPoints.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .map(entry -> entry.getKey().toUpperCase())
            .collect(Collectors.toList());
    }
}
```
#### Mejoras realizadas:

1. Uso de Map.of: En lugar de utilizar HashMap y la sintaxis más verbosa para inicializar los mapas usersWithPoints_Group1, usersWithPoints_Group2 y usersWithPoints_Group3, se ha utilizado el método estático Map.of para una inicialización más concisa.

2. Eliminación de variables redundantes: Se han eliminado las variables users1, users2 y users3, ya que no son necesarias. Los usuarios se agregan directamente a la lista principal users durante la iteración.

3. Uso de List<List<String>>: En lugar de utilizar ArrayList<ArrayList<String>>, se ha cambiado el tipo de datos a List<List<String>> para una mayor generalidad y flexibilidad.

4. Encapsulamiento mejorado: Los mapas usersWithPoints_Group1, usersWithPoints_Group2 y usersWithPoints_Group3 ahora son private y se ha eliminado la posibilidad de modificarlos desde fuera de la clase, lo que mejora el encapsulamiento y la consistencia del estado interno.

5. Nombres más descriptivos: Los nombres de las variables y métodos se han mejorado para hacer el código más legible y comprensible.

6. Mayor modularidad: Se ha introducido un método privado getSortedAndCapitalizedUsers para evitar la duplicación de código y facilitar la lectura y comprensión de la lógica de ordenamiento y capitalización de usuarios.

Estas mejoras aumentan la legibilidad, modularidad y mantenibilidad del código, al tiempo que mantienen la funcionalidad original de obtener los usuarios ordenados y capitalizados por puntos en cada grupo.
