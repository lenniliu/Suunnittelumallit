package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatClient {
    private Map<String, Client> clients = new HashMap<>();

    public void registerClient(Client client) {
        clients.put(client.getUsername(), client);
    }

    public void sendMessage(Message message) {
        Client recipient = clients.get(message.getRecipient());
        if (recipient != null) {
            recipient.receiveMessage(message);
        } else {
            System.out.println("Recipient not found!");
        }
    }
}

