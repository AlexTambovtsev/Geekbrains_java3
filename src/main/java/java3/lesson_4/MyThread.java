package java3.lesson_4;

import java.io.FileWriter;
import java.io.IOException;

public class MyThread extends Thread {
    private static Object monitor = new Object();
    private String fileName;
    public MyThread(String fileName) {
        this.fileName = fileName;
    }
    public void run() {
        synchronized (monitor) {
            try {
                Thread.sleep(200);
                try {
                    writeFile();
                } catch (IOException e) {
                    System.out.println("IO"+ this.getName());
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                System.out.println("I"+ this.getName());
                e.printStackTrace();
            }
        }
    }
    public void writeFile() throws IOException {
        String data = "This is a string\n";
        FileWriter fr = new FileWriter(fileName, true);
        fr.write(data);
        //fr.flush();
        fr.close();
        System.out.println("Thread:" +this.getName());
    }
}
