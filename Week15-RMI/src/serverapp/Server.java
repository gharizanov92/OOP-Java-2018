package serverapp;
// Set up a server that will receive a connection from a client, send 
// a string to the client, and close the connection.

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Server extends Application {

    private TextField txtInputLink; // inputs message from user
    private TextArea txaChatText;// display information to user

    private ExecutorService threadExecutor;
    private ServerSocket server; // server socket
    private List<RunClient> clients;
    private int counter = 1; // counter of number of connections
    private RunClient client;
    private Hashtable<Thread, ObjectOutputStream> writers;

    /*  Mode to RunClient ****************
    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private Socket connection; // connection to client
    Hashtableis threadsafe because the get, put, contains methods 
    etc are synchronized. Furthermore, Several threads will not 
    be able to access the hashtable at the same time, regardless 
    of which entries they are modifying */
    // set up GUI
    @Override
    public void start(Stage primaryStage) {

        clients = new Vector<>(); //Vector is threadsafe 
        writers = new Hashtable<>();
        threadExecutor = Executors.newCachedThreadPool();
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(14));
        root.setSpacing(8);
        txtInputLink = new TextField();
        txtInputLink.setPromptText("Type text");
        txaChatText = new TextArea();
        txtInputLink.setOnAction(event -> {
            sendData(txtInputLink.getText());
            txtInputLink.setText("");
        }
        ); // end call to handle(ActionEvent evt)
        txtInputLink.setEditable(false);

        txaChatText.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
        root.getChildren().addAll(txtInputLink, txaChatText);
        Scene scene = new Scene(root, 350, 250, Color.web("#666970"));
        // shutdown thread gracefully
        primaryStage.setOnCloseRequest(evt -> stop());
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        // start the server in a separate Thread
        new Thread(() -> runServer()).start();
    }

    public class RunClient implements Runnable {

        private ObjectOutputStream output; // output stream to client
        private ObjectInputStream input; // input stream from client
        private final Socket connection; // connection to client
        private final int counter;

        public RunClient(Socket connection, int counter) {

            this.connection = connection;
            this.counter = counter;

        }

        // get streams to send and receive data
        private void getStreams() throws IOException {
            // set up output stream for objects
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush(); // flush output buffer to send header information

            // set up input stream for objects
            input = new ObjectInputStream(connection.getInputStream());
            // add outoutStream to the table of writers
            writers.put(Thread.currentThread(), output);

            displayMessage("\nGot I/O streams\n");
            
        } // end method getStreams

        @Override
        public void run() {

            displayMessage("Connection " + counter + " received from: "
                    + connection.getInetAddress().getHostName());

            try {
                getStreams();
                processConnection();
            } catch (EOFException eofException) {
                displayMessage("\nServer terminated connection");
            } // end catch
            catch (IOException ex) {
                displayMessage("\nClient terminated connection");
            } finally {
                closeConnection(); //  close connection

            } // end finally
            
        }
        // process connection with client

        private void processConnection() throws IOException {
            String message = "\nSERVER>>> Connection successful";
            output.writeObject(message); // send connection successful message
            displayMessage(message);
            displayMessage("\nSERVER>>> Waiting for new connection\n");
            do // process messages sent from client
            {
                try // read message and display it
                {
                    message = (String) input.readObject(); // read new message
                    displayMessage("\n" + message); // display message
                } // end try
                catch (ClassNotFoundException classNotFoundException) {
                    displayMessage("\nUnknown object type received");
                } // end catch

            } while (!message.equals("CLIENT>>> TERMINATE"));
        } // end method processConnection
        // send message to client

        // close streams and socket
        private void closeConnection() {
            displayMessage("\nTerminating connection No." + this.counter + "\n");

            if (clients.size() == 1) {
                setTextFieldEditable(false);
            } // disable enterField if no more clinets are active

            try {
                if (output != null) {
                    output.close(); // close output stream
                }
                if (output != null) {
                    writers.remove(Thread.currentThread());
                }
                if (input != null) {
                    input.close(); // close input stream
                }
                if (connection != null) {
                    connection.close(); // close socket
                }
            } // end try
            catch (IOException ioException) {
                ioException.printStackTrace();
            } // end catch
            clients.remove(clients.size() - 1);
        } // end method closeConnection
    } // end of RunClient

    // set up and run server 
    public void runServer() {

        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket
           displayMessage("Waiting for connection\n");
            while (true) {
                
                waitForConnection(); // wait for a connection                                 
            } // end while
        } // end try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
    } // end method runServer

    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException {

        Socket s = server.accept();
        
        client = new RunClient(s, counter);
        threadExecutor.execute(client);
        clients.add(client);
        // enable enterField so server user can send messages
        if (clients.size() == 1) {
            setTextFieldEditable(true);
        }

        counter++;
    } // end method waitForConnection

    // send message to client
    private void sendData(String message) {
        try // broadcast message to clients
        {   displayMessage("\nSERVER>>> " + message);
            Set<Thread> threads = writers.keySet();
            for (Thread thread : threads) {
                writers.get(thread).writeObject("SERVER>>> " + message);
                writers.get(thread).flush(); // flush output to client
               
            }
        } // end try
        catch (IOException ioException) {
            txaChatText.appendText("\nError writing object");
        } // end catch
    } // end method sendData

    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        Platform.runLater(()
                -> // updates displayArea
                {
                    txaChatText.appendText(messageToDisplay); // append message
                } // end method run

        ); // end call to Platfrom.runLater
    } // end method displayMessage

    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        Platform.runLater(()
                -> // sets enterField's editability
                {
                    txtInputLink.setEditable(editable);
                } // end method run

        ); // end call to Platfrom.runLater
    } // end method setTextFieldEditable

    @Override
    public void stop() {
        Platform.exit();
        threadExecutor.shutdown();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
