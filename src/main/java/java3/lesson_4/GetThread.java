package java3.lesson_4;

import javax.swing.text.html.ObjectView;
import java.io.IOException;
import java.util.ArrayList;

public class GetThread extends Thread {

    private int maxThreads = 10;
    private volatile static int numOfThreads = 0;
    private boolean flag1=false;
    private boolean flag2=false;
    private ReadFile file = new ReadFile();
    private int index = 0;
    public void run() {
        boolean stop = false;
        while (!stop) {
            try {
                this.sleep(50);
                while (numOfThreads > maxThreads) {
                    if (!flag2) {
                        flag2 = true;
                        flag1 = false;
                        numOfThreads--;
                    }
                    try {
                        this.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println(this.getName());
                    stop = file.readFile("file.txt", index);
                    if (!flag1) {
                        numOfThreads++;
                        flag1 = true;
                    }
                    index++;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                flag2 = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread: " + this.getName() + "is stopped");
        maxThreads--;
    }
}
