package sockets.multiple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    // don't do it like this (synchronize)
    public static List<Socket> clients = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // unlimited connections pool
        final ExecutorService clientPool = Executors.newCachedThreadPool();

        final ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for client to join...");

        clientPool.submit(() -> {
            while (true) {
                // wait for a connection
                final Socket connection = server.accept();
                clients.add(connection);
                System.out.println("Client connected!");

                clientPool.submit(() -> {
                    try {
                        final Scanner socketScanner = new Scanner(connection.getInputStream());

                        while (socketScanner.hasNext()) {
                            final String msg = socketScanner.nextLine();
                            // broadcast!

                            for (final Socket client : clients) {
                                // don't echo message back
                                if (client != connection) {
                                    final OutputStream outputStream = client.getOutputStream();
                                    outputStream.write(msg.getBytes());
                                    outputStream.write('\n');
                                    outputStream.flush();
                                }
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }
}
