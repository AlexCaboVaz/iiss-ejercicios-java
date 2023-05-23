package Java2.Ej2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> elements2 = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        CompletableFuture<Integer> additionFuture = AsynchronousAPI.additionAsync(elements);
        CompletableFuture<Integer> multiplicationFuture = AsynchronousAPI.multiplicationAsync(elements2);

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(additionFuture, multiplicationFuture);
        completableFuture.thenRun(() -> {
            try {
                int additionResult = additionFuture.get();
                int multiplicationResult = multiplicationFuture.get();

                System.out.println("The result is " + (additionResult + multiplicationResult));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        completableFuture.get();
    }
}