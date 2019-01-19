package sockets.multiple;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

public class ConnectionProvider {

    public static CompletableFuture<Socket> acquireConnection(final String host, final int port) {
        final CompletableFuture<Socket> connectionPromise = new CompletableFuture<>();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Attempting to connect...");
                    final Socket connection = new Socket(host, port);
                    System.out.println("Connection acquired!");

                    connectionPromise.complete(connection);

                    return;
                } catch (IOException e) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }).start();

        return connectionPromise;
    }
}
