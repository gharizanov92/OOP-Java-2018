package first.daemons;

public class DaemonThread {

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            try {
                Thread.sleep(100000);
                threadFinished();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread normaLThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                threadFinished();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        normaLThread.start();

        thread.setDaemon(true);
        thread.start();

        threadFinished();
    }

    public static void threadFinished() {
        System.out.printf("%s has finished! %n", Thread.currentThread().getName());
    }

}
