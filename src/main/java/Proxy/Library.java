package Proxy;

import java.util.HashMap;

public class Library {
    private final HashMap<String, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String content) {
        documents.put(id, new RealDocument(id, content));
    }

    public void addProtectedDocument(String id, String content, String... allowedUsers) {
        RealDocument realDocument = new RealDocument(id, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);

        AccessControlService accessControl = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            accessControl.allowAccess(id, user);
        }
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}
