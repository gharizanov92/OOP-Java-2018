package sockets.multiple;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        final Scanner in = new Scanner(System.in);

        // loopback
        final CompletableFuture<Socket> socketPromise =
                ConnectionProvider.acquireConnection("127.0.0.1", 12345);

        final Socket connection = socketPromise.get();
        System.out.println("Connected!");

        new MessagingService(connection,
                msg -> System.out.printf("<< %s\n", msg),
                (new Scanner(System.in)::nextLine));
    }
}
