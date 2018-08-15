package java3.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrToList<T> {
    private T[] obj;
    public ArrToList(T[] obj) {
        this.obj = obj;
    }
    public ArrayList<T> getList() {
        ArrayList<T> list = new ArrayList<T>();
        Collections.addAll(list, obj);
        return list;
    }
    public void changeElements(int a, int b) {
        T buff;
        if (a >= obj.length || b >= obj.length || a < 0 || b < 0) {
            System.out.println("Crash!!!");
        }
        else {
            buff = obj[a];
            obj[a] = obj[b];
            obj[b] = buff;
        }
    }
}
