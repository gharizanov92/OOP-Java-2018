package first.threads.access;

import java.util.LinkedList;
import java.util.List;

public class ConcurrentAccessTest {
    public static void main(String[] args) {
        final SharedResource sharedResource = new SharedResource();

        final List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            final Thread threadIncrement = new Thread(new WorkerThread(true,
                    sharedResource, i, 100));
            final Thread threadDecrement = new Thread(new WorkerThread(false,
                    sharedResource, i, 100));

            threads.add(threadIncrement);
            threads.add(threadDecrement);

            threadIncrement.start();
            threadDecrement.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sharedResource.getCount());
    }
}
