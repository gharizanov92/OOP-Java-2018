package second.threads.basic;

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
            System.out.printf(String.format("Thread<%d> :%d\n", id, i));
        }
    }
}
