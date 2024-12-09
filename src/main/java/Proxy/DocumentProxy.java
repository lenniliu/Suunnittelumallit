package Proxy;

public class DocumentProxy implements Document {
    private final RealDocument document;

    public DocumentProxy(RealDocument document) {
        this.document = document;
    }

    @Override
    public String getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService accessControl = AccessControlService.getInstance();
        if (accessControl.isAllowed(document.getId(), user.getUsername())) {
            return document.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}

