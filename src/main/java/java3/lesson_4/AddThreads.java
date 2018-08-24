package java3.lesson_4;

import java.util.ArrayList;

public class AddThreads {
    private int numOfThreads;
    private ArrayList<Thread> treads = new ArrayList<Thread>();

    public AddThreads(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        for (int i = 0; i < numOfThreads; i++) {
            treads.add(new GetThread());
        }
    }

    public ArrayList<Thread> getTreads() {
        return treads;
    }
}
