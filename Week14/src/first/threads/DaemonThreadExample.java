package first.threads;

public class DaemonThreadExample {
    public static void main(String[] args) {

        final Thread thread = new Thread(() -> {
            while (true) {

            }
        });

        thread.setDaemon(true); // don't wait for this thread
        thread.start();
    }
}
