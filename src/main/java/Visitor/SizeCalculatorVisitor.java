package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // No action needed for directories in this visitor
    }

    public double getTotalSize() {
        return totalSize;
    }
}

