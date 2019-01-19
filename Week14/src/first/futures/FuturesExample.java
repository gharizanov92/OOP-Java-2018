package first.futures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FuturesExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final LongRunningTask longRunningTask = new LongRunningTask();

        final Future<Integer> integerFuture =
                longRunningTask.calculateLongTask();

        System.out.println("Waiting for result... ");
        System.out.println("Got result " + integerFuture.get());
    }
}
