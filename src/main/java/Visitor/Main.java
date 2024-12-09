package Visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create files
        File file1 = new File("document.txt", 5.5);
        File file2 = new File("photo.jpg", 2.3);
        File file3 = new File("report.pdf", 3.8);
        File file4 = new File("image.png", 1.2);

        // Create directories and add files
        Directory dir1 = new Directory("Documents");
        dir1.addElement(file1);
        dir1.addElement(file2);

        Directory dir2 = new Directory("Reports");
        dir2.addElement(file3);
        dir2.addElement(file4);

        // Create a root directory and add subdirectories
        Directory root = new Directory("Root");
        root.addElement(dir1);
        root.addElement(dir2);

        // Apply the SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        // Apply the SearchVisitor to find all .jpg files
        SearchVisitor searchVisitor = new SearchVisitor(".jpg");
        root.accept(searchVisitor);
        List<File> jpgFiles = searchVisitor.getMatchingFiles();
        System.out.println("Found JPG files:");
        for (File file : jpgFiles) {
            System.out.println(file.getName());
        }
    }
}

