package sockets.basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        final PrintWriter socketWriter = new PrintWriter(out);

        new Thread(() -> {
            while (consoleInput.hasNext()) {
                final String msg = consoleInput.nextLine();
                socketWriter.println(msg);
                socketWriter.flush();
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
