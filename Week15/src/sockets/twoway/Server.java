package sockets.twoway;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

        final InputStream inputStream = connection.getInputStream();
        final OutputStream out = connection.getOutputStream();

        final Scanner sc = new Scanner(inputStream);

        while (sc.hasNext()) {
            final String msg = sc.nextLine();
            System.out.printf("<< %s\n", msg);
        }
    }
}
