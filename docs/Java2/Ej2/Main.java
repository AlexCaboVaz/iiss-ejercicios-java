package Java2.Ej2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static CompletableFuture<Integer> additionAsync(List<Integer> elements) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int element : elements) {
                System.out.println("Adding " + element);
                sum += element;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        });

        return future;
    }

    public static CompletableFuture<Integer> multiplicationAsync(List<Integer> elements) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int product = 1;
            for (int element : elements) {
                System.out.println("Multiplying " + element);
                product *= element;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return product;
        });

        return future;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> elements2 = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        CompletableFuture<Integer> sumFuture = Main.additionAsync(elements);
        CompletableFuture<Integer> productFuture = Main.multiplicationAsync(elements2);

        CompletableFuture<Integer> combinedFuture = sumFuture.thenCombine(productFuture, (sumResult, productResult) -> sumResult + productResult);

        combinedFuture.thenAccept(result -> System.out.println("The result is " + result));

        combinedFuture.get();
    }
    
}
