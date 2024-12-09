package ChainOfResponsibility;

public abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleMessage(Message message) {
        if (canHandleMessage(message)) {
            processMessage(message);
        } else if (nextHandler != null) {
            nextHandler.handleMessage(message);
        } else {
            System.out.println("No handler found for: " + message);
        }
    }

    protected abstract boolean canHandleMessage(Message message);
    protected abstract void processMessage(Message message);
}


