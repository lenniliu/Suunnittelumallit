package ChainOfResponsibility;

public class DevelopmentSuggestHandler extends Handler {

    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("Logging development suggestion: " + message.getContent());
        System.out.println("Response: Thank you for your suggestion! It has been logged for review.");
    }
}

