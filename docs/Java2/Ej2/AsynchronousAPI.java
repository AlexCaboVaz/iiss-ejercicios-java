package Java2.Ej2;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsynchronousAPI {

    public static CompletableFuture<Integer> additionAsync(List<Integer> elements) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            int sum = 0;
            for (Integer element : elements) {
                System.out.println("Adding " + element);
                sum += element;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    future.completeExceptionally(e);
                }
            }
            future.complete(sum);
        });

        return future;
    }

    public static CompletableFuture<Integer> multiplicationAsync(List<Integer> elements) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            int product = 1;
            for (Integer element : elements) {
                System.out.println("Multiplying " + element);
                product *= element;
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    future.completeExceptionally(e);
                }
            }
            future.complete(product);
        });

        return future;
    }
}
