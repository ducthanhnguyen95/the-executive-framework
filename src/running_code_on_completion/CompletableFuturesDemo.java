package running_code_on_completion;

import callables_and_futures.LongTask;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> 1);

        future.thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });

        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });

        future.thenAccept(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        future.thenAcceptAsync(result -> {
            LongTask.simulate();
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
