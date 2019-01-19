package second.threads.suspend;

public class SuspendableTask implements Runnable {

    private volatile boolean isSuspended = false;

    @Override
    public void run() {
        int cnt = 0;
        while (true) {
            System.out.println(cnt++);

            waitIfSuspended();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void waitIfSuspended() {
        while (isSuspended) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pauseTask() {
        isSuspended = true;
    }

    public synchronized void resumeTask() {
        isSuspended = false;
        notifyAll();
    }
}
