package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        // Chain handlers
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        // Generate messages
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(MessageType.COMPENSATION_CLAIM, "Requesting refund for damaged product", "john.doe@example.com"));
        messages.add(new Message(MessageType.CONTACT_REQUEST, "Need help with my account", "jane.smith@example.com"));
        messages.add(new Message(MessageType.DEVELOPMENT_SUGGESTION, "Add a dark mode feature", "techfan@example.com"));
        messages.add(new Message(MessageType.GENERAL_FEEDBACK, "Great service!", "happy.customer@example.com"));
        messages.add(new Message(MessageType.GENERAL_FEEDBACK, "Very disappointed with delivery time", "angry.customer@example.com"));

        // Process messages
        for (Message message : messages) {
            System.out.println("\nHandling message:");
            compensationHandler.handleMessage(message);
        }
    }
}

