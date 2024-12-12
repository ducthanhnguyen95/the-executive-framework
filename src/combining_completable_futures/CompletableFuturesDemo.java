package combining_completable_futures;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> "20USD");
        var second = CompletableFuture.supplyAsync(() -> 0.9);
        first
                .thenCombine(second, (price, discount) -> Integer.valueOf(price.replace("USD", "")) * discount)
                .thenAccept(System.out::println);
    }
}
