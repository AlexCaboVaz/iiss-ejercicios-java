# Ejercicio 1
```
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("data = " + Arrays.toString(data));

        // Utilizar programación funcional con expresiones lambda y streams
        DataOperations operations = new DataOperations() {
            @Override
            public void print(int[] data) {
                Arrays.stream(data).forEach(element -> System.out.print(element + ", "));
                System.out.println();
            }

            @Override
            public int[] filterPairs(int[] data) {
                return Arrays.stream(data)
                        .filter(element -> (element % 2) != 0)
                        .toArray();
            }
        };

        operations.print(data);
        data = operations.filterPairs(data);
        operations.print(data);
    }
}

```

En el código anterior, hemos reemplazado el uso de bucles for por el uso de Arrays.stream() y los métodos del API de streams de Java. En el método print(), utilizamos Arrays.stream(data) para obtener un IntStream y luego aplicamos forEach() con una expresión lambda para imprimir cada elemento. En el método filterPairs(), utilizamos Arrays.stream(data) para obtener un IntStream, luego aplicamos filter() con una expresión lambda que filtra los elementos impares y finalmente convertimos el IntStream resultante en un array usando toArray().

Esta implementación utiliza programación funcional y aprovecha las capacidades de las expresiones lambda y el API de streams de Java para lograr un código más conciso y legible.


# Ejercicio 2

```
import java.util.Arrays;
import java.util.List;

public interface DataOperations {
    void print(int[] data);
    int[] filterPairs(int[] data);
    List<Integer> sortDescending(int[] data);
    void multiplyByTenAndPrint(int[] data);
    int sum(int[] data);
}

public class DataOperationsImpl implements DataOperations {
    @Override
    public void print(int[] data) {
        Arrays.stream(data).forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    @Override
    public int[] filterPairs(int[] data) {
        return Arrays.stream(data)
                .filter(element -> (element % 2) != 0)
                .toArray();
    }

    @Override
    public List<Integer> sortDescending(int[] data) {
        return Arrays.stream(data)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .toList();
    }

    @Override
    public void multiplyByTenAndPrint(int[] data) {
        Arrays.stream(data)
                .map(element -> element * 10)
                .forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    @Override
    public int sum(int[] data) {
        return Arrays.stream(data).sum();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("data = " + Arrays.toString(data));

        DataOperations operations = new DataOperationsImpl();
        operations.print(data);
        data = operations.filterPairs(data);
        operations.print(data);

        List<Integer> sortedList = operations.sortDescending(data);
        System.out.println("Sorted Descending: " + sortedList);

        operations.multiplyByTenAndPrint(data);

        int sum = operations.sum(data);
        System.out.println("Sum: " + sum);
    }
}
```

- En este ejemplo, hemos agregado tres operaciones adicionales a la interfaz DataOperations: sortDescending(), multiplyByTenAndPrint(), y sum(). Luego, en la implementación DataOperationsImpl, hemos proporcionado la implementación de estas operaciones utilizando expresiones lambda y el API de streams.

- La operación sortDescending() toma la matriz de números data, la convierte en un IntStream, la convierte en un Stream<Integer> utilizando el método boxed(), y luego utiliza el método sorted() con una expresión lambda que compara los elementos en orden descendente. Finalmente, se convierte el Stream<Integer> resultante en una lista utilizando toList().

- La operación multiplyByTenAndPrint() toma la matriz de números data, utiliza Arrays.stream() para obtener un IntStream, y luego utiliza el método map() con una expresión lambda para multiplicar cada elemento por 10. Luego, se utiliza forEach() para imprimir cada elemento multiplicado.

- La operación sum() simplemente utiliza Arrays.stream() para obtener un IntStream y luego utiliza el método sum() para calcular la suma de todos los elementos.

- En el método main(), se realiza la prueba de todas las operaciones agregadas