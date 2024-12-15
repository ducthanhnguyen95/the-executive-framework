package exercise;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void show() {
        var start = LocalDateTime.now();
        var service = new FlightService();
        var futures = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var endTime = LocalDateTime.now();
                    Duration duration = Duration.between(start, endTime);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " ms.");
                });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
