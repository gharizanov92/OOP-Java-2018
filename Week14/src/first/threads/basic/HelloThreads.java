package first.threads.basic;

public class HelloThreads {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            final Thread thread = new Thread(new SimpleTask(i, 10), "My Thread " + i);
            thread.start();
        }
    }
}
