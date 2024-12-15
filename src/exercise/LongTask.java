package exercise;

public class LongTask {

    /**
     * Simulates a long-running task by pausing the execution
     * of the current thread for a specified duration.
     * This method introduces an artificial delay to mimic a time-consuming operation.
     *
     * @throws RuntimeException if the thread is interrupted while sleeping
     */
    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Simulates a delay by pausing the execution of the current thread
     * for the specified duration in milliseconds.
     * This method is useful for mimicking time-consuming operations.
     *
     * @param delay the duration of the delay in milliseconds
     * @throws RuntimeException if the thread is interrupted while sleeping
     */
    public static void simulate(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
