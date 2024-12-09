package ChainOfResponsibility;

public class GeneralFeedbackHandler extends Handler {

    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("Analyzing general feedback: " + message.getContent());
        System.out.println("Response: Thank you for your feedback!");
    }
}

