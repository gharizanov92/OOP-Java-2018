package service;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        final Socket connection = new Socket("127.0.0.1", 12345);
        System.out.println("Connected!");

        new MessagingService(connection,
                msg -> System.out.printf("<< %s\n", msg),
                (new Scanner(System.in)::nextLine));
    }
}
