package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchCriterion;
    private List<File> matchingFiles;

    public SearchVisitor(String searchCriterion) {
        this.searchCriterion = searchCriterion;
        this.matchingFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().endsWith(searchCriterion)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // No action needed for directories in this visitor
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}

