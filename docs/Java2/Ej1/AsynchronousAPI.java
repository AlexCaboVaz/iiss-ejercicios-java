import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsynchronousAPI {

    public static Future<Integer> additionAsync(List<Integer> elements) throws InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                int sum = 0;
                for (Integer element : elements) {
                    System.out.println("Adding " + element);
                    TimeUnit.SECONDS.sleep(5); // Simulate a delay of 5 seconds
                    sum += element;
                }
                completableFuture.complete(sum);
            } catch (InterruptedException e) {
                completableFuture.completeExceptionally(e);
            }
        });

        return completableFuture;
    }
}
