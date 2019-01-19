package first.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class LongRunningTask {
    public Future<Integer> calculateLongTask() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                future.complete(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return future;
    }
}
