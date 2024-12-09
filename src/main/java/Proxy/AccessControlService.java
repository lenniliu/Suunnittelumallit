package Proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final HashMap<String, Set<String>> permissions;

    private AccessControlService() {
        permissions = new HashMap<>();
    }

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String documentId, String username) {
        permissions.computeIfAbsent(documentId, k -> new HashSet<>()).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.containsKey(documentId) && permissions.get(documentId).contains(username);
    }
}
