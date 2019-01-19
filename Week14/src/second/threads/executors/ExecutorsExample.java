package second.threads.executors;

import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {
    public static void main(String[] args) throws InterruptedException {
        final SharedResource sharedResource = new SharedResource();

        final ExecutorService threads = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            threads.submit(new SharedTask(true, sharedResource, i, 100));
            threads.submit(new SharedTask(false, sharedResource, i, 100));
        }

        threads.shutdown();
        threads.awaitTermination(1000, TimeUnit.SECONDS);

        System.out.println(sharedResource.getCnt());
    }
}
