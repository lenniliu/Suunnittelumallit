package ChainOfResponsibility;

public class CompensationClaimHandler extends Handler {

    @Override
    protected boolean canHandleMessage(Message message) {
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void processMessage(Message message) {
        System.out.println("Processing compensation claim: " + message.getContent());
        System.out.println("Response: Your claim is under review, we will contact you at " + message.getSenderEmail());
    }
}
