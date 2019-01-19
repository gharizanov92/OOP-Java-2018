package sockets.twoway;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        final Socket connection = new Socket("127.0.0.1", 12345);
        System.out.println("Connected!");

        final InputStream inputStream = connection.getInputStream();
        final OutputStream outputStream = connection.getOutputStream();

        final Scanner socketScanner = new Scanner(inputStream);
        final PrintWriter pw = new PrintWriter(outputStream);

        while (in.hasNext()) {
            final String msg = in.nextLine();
            pw.println(msg);
            pw.flush();
        }

        while (socketScanner.hasNext()) {
            System.out.println(socketScanner.nextLine());
        }

    }
}
