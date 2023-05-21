# Ejercico 2
## Primera Parte

### AsyncrhonousAPI
    En el método additionAsync, hemos utilizado un CompletableFuture para realizar la suma de forma asíncrona. Hemos creado un nuevo ExecutorService utilizando Executors.newCachedThreadPool() y hemos enviado la lógica de suma en un hilo separado. Dentro del bucle, mostramos cada elemento que se está sumando y agregamos un retardo de 2 segundos utilizando TimeUnit.SECONDS.sleep(2). Luego, completamos el futuro con el resultado de la suma.

    En el método multiplicationAsync, hemos seguido una lógica similar a additionAsync, pero realizando la multiplicación en lugar de la suma. Mostramos cada elemento que se está multiplicando y agregamos un retardo de 3 segundos utilizando TimeUnit.SECONDS.sleep(3). Luego, completamos el futuro con el resultado del producto.

## Main

    En el método main, creamos dos futuros (additionFuture y multiplicationFuture) llamando a los métodos additionAsync y multiplicationAsync respectivamente. Luego, utilizamos CompletableFuture.allOf para combinar ambos futuros en un nuevo CompletableFuture llamado completableFuture. Después, agregamos un thenRun para imprimir el resultado cuando ambos futuros se completen. Dentro de thenRun, obtenemos los resultados de los futuros (additionResult y multiplicationResult) y mostramos la suma total.

    Finalmente, llamamos a completableFuture.get() para esperar hasta que se completen todos los cálculos asincrónicos.


## Segunda Parte

```
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> elements2 = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        CompletableFuture<Integer> additionFuture = AsynchronousAPI.additionAsync(elements);
        CompletableFuture<Integer> multiplicationFuture = AsynchronousAPI.multiplicationAsync(elements2);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(additionFuture, multiplicationFuture);

        CompletableFuture<Integer> sumResult = completableFuture.thenApplyAsync(voidResult -> {
            try {
                int additionResult = additionFuture.get();
                int multiplicationResult = multiplicationFuture.get();
                return additionResult + multiplicationResult;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return 0;
            }
        });

        sumResult.thenAccept(result -> System.out.println("The result is " + result));

        completableFuture.get();
    }
}
```

- Asi seria el Main modificado.
- En este código, hemos utilizado CompletableFuture.thenApplyAsync para realizar la suma de los resultados en paralelo. Después de combinar los futuros additionFuture y multiplicationFuture con CompletableFuture.allOf, aplicamos una función lambda usando thenApplyAsync para obtener el resultado de la suma. Dentro de la función lambda, obtenemos los resultados de los futuros (additionResult y multiplicationResult) y los sumamos. Luego, el resultado se pasa a thenAccept para imprimirlo en la consola.

- Al usar thenApplyAsync, la suma se realiza en paralelo de forma asíncrona, lo que permite un mejor rendimiento cuando se manejan operaciones largas o pesadas.