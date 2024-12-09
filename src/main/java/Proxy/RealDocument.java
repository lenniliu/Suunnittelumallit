package Proxy;

import java.time.LocalDate;

public class RealDocument implements Document {
    private final String id;
    private final String content;
    private final String creationDate;

    public RealDocument(String id, String content) {
        this.id = id;
        this.content = content;
        this.creationDate = LocalDate.now().toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
