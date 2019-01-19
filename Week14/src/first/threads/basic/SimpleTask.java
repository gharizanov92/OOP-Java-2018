package first.threads.basic;

public class SimpleTask implements Runnable {

    private int id;
    private int count;

    public SimpleTask(int id, int count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread<%d> (%s): %d\n", id, Thread.currentThread().getName(), i);
        }
    }
}
