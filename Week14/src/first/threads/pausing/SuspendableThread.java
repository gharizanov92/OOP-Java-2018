package first.threads.pausing;

public class SuspendableThread implements Runnable {

    private volatile boolean isSuspended;
    private Object lock = new Object();

    @Override
    public void run() {
        int cnt = 0;
        while (true) {
            try {
                System.out.println(cnt++);

                waitIfSuspended();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void waitIfSuspended() throws InterruptedException {
        while (isSuspended) {
            wait();
        }
    }

    public synchronized void resume() {
        isSuspended = false;
        notifyAll();
    }

    public void pause() {
        isSuspended = true;
    }
}
