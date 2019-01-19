package first.threads.executors;

public class WorkerThread implements Runnable {

    private boolean shouldIncrement = true;
    private SharedResource sharedResource;
    private int id;
    private int count;

    public WorkerThread(boolean shouldIncrement, SharedResource sharedResource, int id, int count) {
        this.shouldIncrement = shouldIncrement;
        this.sharedResource = sharedResource;
        this.id = id;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            if (shouldIncrement) {
                sharedResource.increment();
            } else {
                sharedResource.decrement();
            }
        }
    }
}
