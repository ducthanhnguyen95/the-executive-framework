package waiting_for_many_tasks_to_complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesDemo {

    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);
        var all = CompletableFuture.allOf(first, second, third);

        all.thenRun(() -> {
            try {
                var firstResult = first.get();
                System.out.println(firstResult);
                var secondResult = second.get();
                System.out.println(secondResult);
                var thirdResult = third.get();
                System.out.println(thirdResult);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All tasks completed successfully");
        });

    }
}
