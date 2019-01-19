package second.threads.executors;

public class SharedResource {
    private int cnt;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void increment() {
        synchronized (lock1) {
            synchronized (lock2) {
                cnt++;
            }
        }
    }

    public void decrement() {
        // if lock2 -> lock1
        /*
            synchronized (lock2) {
                synchronized (lock1) {
                   deadlock
                }
            }
         */
        synchronized (lock1) {
            synchronized (lock2) {
                cnt--;
            }
        }
    }

    public int getCnt() {
        return cnt;
    }
}
