package first.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentAccessTest {
    public static void main(String[] args) throws InterruptedException {
        final SharedResource sharedResource = new SharedResource();

        final ExecutorService threads = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            threads.submit(new WorkerThread(true,
                    sharedResource, i, 100));

            threads.submit(new WorkerThread(false,
                    sharedResource, i, 100));
        }

        // first.threads.shutdown();
        // first.threads.awaitTermination(1000, TimeUnit.SECONDS);

/*        while (true) {
            Thread.sleep(100);
            System.out.println(sharedResource.getCount());
        }*/
    }
}
