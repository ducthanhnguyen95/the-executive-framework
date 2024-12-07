package executors;

import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void show() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        } finally {
            executor.shutdown();
        }
    }
}
