package sockets.clientretry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MessagingService {
    private final Consumer<String> messageConsumer;
    private final Supplier<String> messageSupplier;
    private InputStream inputStream;
    private OutputStream outputStream;

    private Scanner socketScanner;
    private PrintWriter socketWriter;

    public MessagingService(final Socket connection,
                            final Consumer<String> messageConsumer,
                            final Supplier<String> messageSupplier)
            throws IOException {
        this.inputStream = connection.getInputStream();
        this.outputStream = connection.getOutputStream();
        this.messageConsumer = messageConsumer;
        this.messageSupplier = messageSupplier;

        socketScanner = new Scanner(inputStream);
        socketWriter = new PrintWriter(outputStream);

        initMessageReceiver();
        initMessageSupplier();
    }

    private void initMessageSupplier() {
        new Thread(()-> {
            while (true) {
                final String msg = messageSupplier.get();
                /*socketWriter.write(msg);
                socketWriter.write("\n");
                socketWriter.flush();*/
                try {
                    outputStream.write(msg.getBytes());
                    outputStream.write('\n');
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initMessageReceiver() {
        new Thread(()-> {
            while (socketScanner.hasNext()) {
                final String msg = socketScanner.nextLine();
                messageConsumer.accept(msg);
            }
        }).start();
    }
}
