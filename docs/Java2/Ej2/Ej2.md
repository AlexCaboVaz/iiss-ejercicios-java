# Ejercico 2
## Primera Parte

- Los métodos additionAsync y multiplicationAsync utilizan CompletableFuture.supplyAsync para realizar las sumas y multiplicaciones de forma asíncrona. Se muestra un mensaje por consola para cada elemento que se está sumando o multiplicando, y se añade un retardo utilizando Thread.sleep para simular una operación lenta.

- En la clase Main, se crean dos CompletableFuture para las sumas y multiplicaciones respectivamente. Luego se utiliza CompletableFuture.allOf para combinar ambos futuros en un solo CompletableFuture que se completará cuando ambos hayan terminado. Se agrega un thenRun para imprimir el resultado de la suma completa junto con el mensaje correspondiente.

- Al ejecutar el método get en el CompletableFuture final, el programa se bloqueará hasta que todos los cálculos asíncronos hayan terminado y se haya impreso el resultado.

```
public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> elements2 = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        CompletableFuture<Integer> sumFuture = Main.additionAsync(elements);
        CompletableFuture<Integer> productFuture = Main.multiplicationAsync(elements2);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(sumFuture, productFuture);

        completableFuture.thenRun(() -> {
            try {
                int sumResult = sumFuture.get();
                int productResult = productFuture.get();
                System.out.println("The result is " + (sumResult + productResult));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        completableFuture.get();
    }
```

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

        CompletableFuture<Integer> sumFuture = AsynchronousAPI.additionAsync(elements);
        CompletableFuture<Integer> productFuture = AsynchronousAPI.multiplicationAsync(elements2);

        CompletableFuture<Integer> combinedFuture = sumFuture.thenCombine(productFuture, (sumResult, productResult) -> sumResult + productResult);

        combinedFuture.thenAccept(result -> System.out.println("The result is " + result));

        combinedFuture.get();
    }
}
```

- En este código, utilizamos CompletableFuture.thenCombine() para combinar los resultados de sumFuture y productFuture sumándolos juntos. Luego, utilizamos thenAccept() para mostrar el resultado por consola.

- Asegúrate de tener también el código actualizado de la clase AsynchronousAPI como se proporcionó anteriormente.

- De esta manera, los cálculos de suma y multiplicación se realizarán en paralelo, y el resultado se mostrará por consola cuando esté disponible.