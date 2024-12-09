package Proxy;

public interface Document {
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}

