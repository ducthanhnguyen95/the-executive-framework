package transforming_a_completable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    private static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8) + 32;
    }

    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> 20);
        future
                .thenApply(CompletableFuturesDemo::toFahrenheit)
                .thenAccept(result -> System.out.println(result));

    }
}
