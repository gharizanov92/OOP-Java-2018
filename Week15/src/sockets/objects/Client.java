package sockets.objects;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final Scanner consoleInput = new Scanner(System.in);

        final Socket connection = new Socket("127.0.0.1", 12345);
        System.out.println("Connected!");

        final InputStream inputStream = connection.getInputStream();
        final OutputStream out = connection.getOutputStream();

        final Scanner socketInput = new Scanner(inputStream);
        final ObjectOutputStream socketWriter = new ObjectOutputStream(out);

        new Thread(() -> {
            while (consoleInput.hasNext()) {
                final String msg = consoleInput.nextLine();
                try {
                    socketWriter.writeObject(new Message("Client1", msg));
                    socketWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (socketInput.hasNext()) {
                final String msg = socketInput.nextLine();
                System.out.printf("<< %s\n", msg);
            }
        }).start();

    }
}
