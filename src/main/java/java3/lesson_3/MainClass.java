package java3.lesson_3;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        new Server();
        try {
            new WorkWithFiles().mergeFiles(new WorkWithFiles().addFiles("file.txt", "file2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            long startTime = System.currentTimeMillis();
            new WorkWithFiles().readPage("file2.txt");
            System.out.println(System.currentTimeMillis() - startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
