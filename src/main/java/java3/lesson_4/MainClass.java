package java3.lesson_4;

import java.io.IOException;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread("file.txt");
//        MyThread t2 = new MyThread("file.txt");
//        MyThread t3 = new MyThread("file.txt");
//        t1.start();
//        t2.start();
//        t3.start();
//        GetCommand com = new GetCommand();
//        Mfu t4 = new Mfu(com);
//        t4.start();
//        Mfu t5 = new Mfu(com);
//        t5.start();
        ArrayList<Thread> treads = new AddThreads(10).getTreads();
        for (int i = 0; i < 10; i++) {
            treads.get(i).start();
        }
//        try {
//            new ReadFile().readFile("file.txt",0);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
