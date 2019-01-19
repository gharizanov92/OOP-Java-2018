package sockets.clientretry;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for client to join...");

        // wait for a connection
        final Socket connection = server.accept();
        System.out.println("Client connected!");

        new MessagingService(connection,
                msg -> System.out.printf("<< %s\n", msg),
                (new Scanner(System.in)::nextLine));
    }
}
