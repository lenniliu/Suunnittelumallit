package Mediator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {
    private String username;
    private TextArea messageArea;
    private TextField inputField;
    private TextField recipientField;
    private Button sendButton;
    private ChatClient mediator;

    public Client(String username, ChatClient mediator) {
        this.username = username;
        this.mediator = mediator;
        this.mediator.registerClient(this);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set up UI components
        messageArea = new TextArea();
        messageArea.setEditable(false);
        inputField = new TextField();
        recipientField = new TextField();
        sendButton = new Button("Send Message");

        sendButton.setOnAction(e -> sendMessage());

        VBox layout = new VBox(10, recipientField, inputField, sendButton, messageArea);
        Scene scene = new Scene(layout, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle(username);
        primaryStage.show();
    }

    public String getUsername() {
        return username;
    }

    public void receiveMessage(Message message) {
        messageArea.appendText(message + "\n");
    }

    private void sendMessage() {
        String messageContent = inputField.getText();
        String recipient = recipientField.getText();
        if (!messageContent.isEmpty() && !recipient.isEmpty()) {
            Message message = new Message(username, recipient, messageContent);
            mediator.sendMessage(message);
            inputField.clear();
        }
    }

    public static void main(String[] args) {
        // Initialize the mediator and clients
        ChatClient mediator = new ChatClient();

        // Create three clients with different usernames
        Client client1 = new Client("Alice", mediator);
        Client client2 = new Client("Bob", mediator);
        Client client3 = new Client("Charlie", mediator);

        // Start the JavaFX application for each client
        client1.start(new Stage());
        client2.start(new Stage());
        client3.start(new Stage());
    }
}

