# Ejercicio 1

- Para utilizar cierres (closures) y mecanismos de programación funcional para cambiar la implementación de las clases DataSorterAsc y DataSorterDesc, se puede utilizar una interfaz funcional que defina una función de ordenamiento personalizada. A continuación se muestra cómo se puede hacer:

1. Define una interfaz funcional SortFunction que representa una función de ordenamiento personalizada. Esta interfaz debe tener un método para ordenar un arreglo de cadenas y devolver el resultado:

```
@FunctionalInterface
public interface SortFunction {
    String[] sort(String[] data);
}
```

2. Modifica las clases DataSorterAsc y DataSorterDesc para que acepten un objeto de tipo SortFunction en su constructor y lo utilicen para realizar el ordenamiento:

```
public class DataSorterAsc implements DataSorter {
    private SortFunction sortFunction;

    public DataSorterAsc(SortFunction sortFunction) {
        this.sortFunction = sortFunction;
    }

    public String[] sort(String[] data) {
        return sortFunction.sort(data);
    }
}

public class DataSorterDesc implements DataSorter {
    private SortFunction sortFunction;

    public DataSorterDesc(SortFunction sortFunction) {
        this.sortFunction = sortFunction;
    }

    public String[] sort(String[] data) {
        return sortFunction.sort(data);
    }
}
```


3. Modifica la clase Main para utilizar cierres y las implementaciones de SortFunction para crear objetos de DataSorterAsc y DataSorterDesc:

```
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        String[] data = {"H", "S", "I", "V", "E", "W", "M", "P", "L",  "C", "N", "K",
                 "O", "A", "Q", "R", "J", "D", "G", "T", "U", "X", "B", "Y", "Z", "F"};
        System.out.println("data = " + Arrays.toString(data));

        SortFunction ascendingSort = dataArray -> {
            Arrays.sort(dataArray);
            return dataArray;
        };

        SortFunction descendingSort = dataArray -> {
            Arrays.sort(dataArray, Collections.reverseOrder());
            return dataArray;
        };

        DataSorter dataSorter = new DataSorterDesc(descendingSort);
        dataSorter.sort(data);
        System.out.println("data (desc) = " + Arrays.toString(data));

        dataSorter = new DataSorterAsc(ascendingSort);
        dataSorter.sort(data);
        System.out.println("data (asc) = " + Arrays.toString(data));
    }
}
```

- En el código modificado, se crean objetos de SortFunction utilizando expresiones lambda. Estas expresiones definen la lógica de ordenamiento personalizada que se desea utilizar. Luego, se pasan estos objetos al constructor de DataSorterAsc y DataSorterDesc al crear los objetos dataSorter. Al llamar al método sort() en los objetos dataSorter, se utilizará la implementación de ordenamiento personalizada proporcionada a través de los cierres.

# Ejercio 2

- Para realizar la ordenación aleatoria de los elementos utilizando cierres (closures), se puede agregar un tercer objeto de SortFunction que implemente la lógica de ordenamiento aleatorio. Aquí está cómo se puede hacer:

1. Agrega una implementación adicional de SortFunction para el ordenamiento aleatorio:

```
SortFunction randomSort = dataArray -> {
    List<String> dataList = Arrays.asList(dataArray);
    Collections.shuffle(dataList);
    return dataList.toArray(new String[0]);
};
```

2. Modifica la clase Main para utilizar el nuevo objeto randomSort:

```
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        String[] data = {"H", "S", "I", "V", "E", "W", "M", "P", "L", "C", "N", "K",
                "O", "A", "Q", "R", "J", "D", "G", "T", "U", "X", "B", "Y", "Z", "F"};
        System.out.println("data = " + Arrays.toString(data));

        SortFunction ascendingSort = dataArray -> {
            Arrays.sort(dataArray);
            return dataArray;
        };

        SortFunction descendingSort = dataArray -> {
            Arrays.sort(dataArray, Collections.reverseOrder());
            return dataArray;
        };

        SortFunction randomSort = dataArray -> {
            List<String> dataList = Arrays.asList(dataArray);
            Collections.shuffle(dataList);
            return dataList.toArray(new String[0]);
        };

        DataSorter dataSorter = new DataSorterDesc(descendingSort);
        dataSorter.sort(data);
        System.out.println("data (desc) = " + Arrays.toString(data));

        dataSorter = new DataSorterAsc(ascendingSort);
        dataSorter.sort(data);
        System.out.println("data (asc) = " + Arrays.toString(data));

        dataSorter = new DataSorterAsc(randomSort);
        dataSorter.sort(data);
        System.out.println("data (random) = " + Arrays.toString(data));
    }
}
```

- En este ejemplo, se crea un nuevo objeto randomSort utilizando una expresión lambda. En este caso, la lógica de ordenamiento consiste en convertir el arreglo de cadenas en una lista, mezclar aleatoriamente los elementos utilizando Collections.shuffle(), y luego convertir la lista resultante de nuevo en un arreglo.

- Luego, se crea un nuevo objeto DataSorterAsc utilizando randomSort como argumento, y se llama al método sort() en este objeto para ordenar los datos de forma aleatoria. Finalmente, se imprime el resultado.

- Con este cambio, se ha agregado una nueva implementación de ordenamiento aleatorio utilizando cierres y programación funcional, siguiendo el mismo enfoque aplicado anteriormente con las clases DataSorterAsc y DataSorterDesc