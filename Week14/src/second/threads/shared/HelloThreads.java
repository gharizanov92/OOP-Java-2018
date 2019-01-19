package second.threads.shared;

import java.util.LinkedList;
import java.util.List;

public class HelloThreads {
    public static void main(String[] args) throws InterruptedException {
        final SharedResource sharedResource = new SharedResource();

        final List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            final Thread thread1 = new Thread(
                    new SharedTask(true, sharedResource, i, 100));

            final Thread thread2 = new Thread(
                    new SharedTask(false, sharedResource, i, 100));

            threads.add(thread1);
            threads.add(thread2);

            thread1.start();
            thread2.start();
        }

        for (final Thread thread : threads) {
            thread.join();
        }

        System.out.println(sharedResource.getCnt());
    }
}
