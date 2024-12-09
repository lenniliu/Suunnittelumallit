package ChainOfResponsibility;

public class ContactRequestHandler extends Handler {

    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("Processing contact request: " + message.getContent());
        System.out.println("Response: Forwarding your request to the support team.");
    }
}
