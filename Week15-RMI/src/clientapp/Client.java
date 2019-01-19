package clientapp;
// Set up a client that will receive a connection from a server, send 
// a string to the server, and close the connection.

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Client extends Application {

    private TextField txtInputLink; // inputs message from user
    private TextArea txaChatText;// display information to user
    private ObjectOutputStream output; // output stream to server
    private ObjectInputStream input; // input stream from server
    private String chatServer; // host server for this application
    private Socket client; // socket to communicate with server    

    private String message = ""; // message from server
    // set up GUI

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(14));
        root.setSpacing(8);
        txtInputLink = new TextField();
        txtInputLink.setPromptText("Type text");
        txaChatText = new TextArea();

        txtInputLink.setEditable(false);///

        txtInputLink.setOnAction(event
                -> {
            sendData(txtInputLink.getText());
            txtInputLink.setText("");
        }
        ); // end call to handle(ActionEvent evt)

        txaChatText.setMaxSize(1.7976931348623157E308, 1.7976931348623157E308);
        root.getChildren().addAll(txtInputLink, txaChatText);
        Scene scene = new Scene(root, 350, 250, Color.web("#666970"));
        // shutdown thread gracefully
        primaryStage.setOnCloseRequest(evt -> stop());
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();
        Thread thread = new Thread(() -> runClient());
        thread.start();
    }

    // connect to server and process messages from server
    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } // end try
        catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } // end catch
        catch (IOException ioException) {
            System.out.println("Client IOexception    " + ioException.getMessage());
        } // end catch
        finally {
            closeConnection(); // close connection
        } // end finally
    } // end method runClient

    // connect to server
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);
        if (client == null) {
//            Platform.exit();
//            System.exit(0);
            stop();
        }
        // display connection information
        displayMessage("Connected to: "
                + client.getInetAddress().getHostName());
    } // end method connectToServer

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    } // end method getStreams

    // process connection with client
    private void processConnection() throws IOException {
        String message = "Connection successful";// message to server
        sendData(message); // send connection successful message

        // enable enterField so server user can send messages
        setTextFieldEditable(true);

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
            catch (SocketException s) {
                break;
            }
        } while (!message.toUpperCase().equals("CLIENT>>> TERMINATE"));
    } // end method processConnection

// close streams and socket
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false); // disable enterField

        try {
            if (output != null) {
                output.close(); // close output stream
            }
            if (input != null) {
                input.close(); // close input stream
            }
            if (client != null) {
                client.close(); // close socket
            }
        } // end try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } // end catch
    } // end method closeConnection

    // send message to client
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nCLIENT>>> " + message);
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
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}// end class Server
