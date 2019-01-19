package sockets.service;

import sockets.objects.Message;

import java.io.*;
import java.net.Socket;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MessagingService {
    private final Consumer<String> messageConsumer;
    private final Supplier<String> messageSupplier;
    private InputStream inputStream;
    private OutputStream outputStream;

    private ObjectInputStream socketScanner;
    private ObjectOutputStream socketWriter;

    public MessagingService(final Socket connection,
                            final Consumer<String> messageConsumer,
                            final Supplier<String> messageSupplier)
            throws IOException {
        this.inputStream = connection.getInputStream();
        this.outputStream = connection.getOutputStream();
        this.messageConsumer = messageConsumer;
        this.messageSupplier = messageSupplier;

        socketScanner = new ObjectInputStream(inputStream);
        socketWriter = new ObjectOutputStream(outputStream);

        initMessageReceiver();
        initMessageSupplier();
    }

    private void initMessageSupplier() {
        new Thread(()-> {
            while (true) {
                final String msg = messageSupplier.get();
                try {
                    socketWriter.writeObject(new Message("Client", msg));
                    socketWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initMessageReceiver() {
        new Thread(()-> {
            while (true) {
                try {
                    final Object msg = socketScanner.readObject();
                    messageConsumer.accept(msg.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
