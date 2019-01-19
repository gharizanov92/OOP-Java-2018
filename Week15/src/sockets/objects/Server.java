package sockets.objects;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        final Scanner consoleInput = new Scanner(System.in);
        final ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for client to join...");

        // wait for a connection
        final Socket connection = server.accept();
        System.out.println("Client connected!");

        final InputStream socketInputStream = connection.getInputStream();
        final OutputStream socketOutput = connection.getOutputStream();

        final ObjectInputStream socketInput = new ObjectInputStream(socketInputStream);
        final PrintWriter socketWriter = new PrintWriter(socketOutput);

        // send messages
        new Thread(() -> {
            while (consoleInput.hasNext()) {
                final String msg = consoleInput.nextLine();
                socketWriter.println(msg);
                socketWriter.flush();
            }
        }).start();

        // receive
        new Thread(() -> {
            while (true) {
                try {
                    final Object msg = socketInput.readObject();
                    System.out.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
