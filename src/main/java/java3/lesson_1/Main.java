package java3.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static String[] arr1 = {"1","2","3","4","5","6","7","8"};
    public static void main(String[] args) {
        new ArrToList<String>(arr1).changeElements(3,0);
       // ArrToList<Integer> list = new ArrToList<Integer>(arr1);
        ArrayList<String> arrList = new ArrToList<String>(arr1).getList();
        System.out.println(arrList.getClass());
        System.out.println("obj: " + arrList);
        System.out.println(arrList.get(0) + arrList.get(1));
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> boxApples = new Box<Apple>(apple);
        boxApples.addFruit();
        boxApples.addFruit();
        boxApples.addFruit();
        Box<Orange> boxOranges = new Box<Orange>(orange);
        boxOranges.addFruit();;
        boxOranges.addFruit();
        boxApples.addFruit();
        boxApples.combineBoxes(boxOranges);
        System.out.println(boxApples.getFruit().getClass());
        System.out.println(boxOranges.getFruit().getClass());
        System.out.println(boxApples.getNumOfFruits());
        System.out.println(boxApples.getWeight());
        System.out.println(boxOranges.getNumOfFruits());
        System.out.println(boxOranges.getWeight());
        System.out.println(boxApples.compare(boxOranges));
    }
//    public static void changeElements(int a, int b) {
//        int buff;
//        if (a >= arr1.length || b >= arr1.length || a < 0 || b < 0) {
//            System.out.println("Crash!!!");
//        }
//        else {
//            buff = arr1[a];
//            arr1[a] = arr1[b];
//            arr1[b] = buff;
//        }
//    }
}
