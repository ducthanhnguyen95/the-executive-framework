package composing_completable_futures;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    private static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    private static CompletableFuture<String> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    public static void show() {
        getUserEmailAsync()
                .thenCompose(CompletableFuturesDemo::getPlaylistAsync)
                .thenAccept(System.out::println);
    }
}
