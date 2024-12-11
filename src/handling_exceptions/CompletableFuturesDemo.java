package handling_exceptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesDemo {

    public static void show() {

//        CompletableFuture.supplyAsync(() -> {
//                    System.out.println("Getting the current weather");
//                    throw new IllegalStateException("Failed to fetch weather data");
//                })
//                .exceptionally(ex -> {
//                    System.out.println("Error occurred: " + ex.getMessage());
//                    return 1; // Default temperature
//                })
//                .thenAccept(temperature -> System.out.println("Temperature: " + temperature));

         var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();
        });

        try {
            var temperature = future.exceptionally(ex -> 1).get();
            System.out.println(temperature);
        } catch (InterruptedException e) {
//            e.getCause();
            e.printStackTrace();
        } catch (ExecutionException e) {
//            e.getCause();
            e.printStackTrace();
        }
    }
}
