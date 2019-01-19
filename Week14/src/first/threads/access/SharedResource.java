package first.threads.access;

public class SharedResource {
    private int count;
    final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public void decrement() {
        synchronized (lock) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
