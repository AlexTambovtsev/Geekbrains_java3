package java3.lesson_1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private T fruit;
    private ArrayList<T> boxArr = new ArrayList<T>();
    private int numOfFruits = 0;

    public Box(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void addFruit() {
        boxArr.add(numOfFruits, fruit);
        numOfFruits++;
    }
    public float getWeight() {
        return fruit.getWeight() * numOfFruits;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }
    public void combineBoxes(Box box) {
        if (!this.fruit.getClass().equals(box.fruit.getClass())) {
            System.out.println("CRASH!!!");
        }
        else {
            for (int i = 0; i < box.numOfFruits; i++) {
                boxArr.add(numOfFruits, fruit);
                numOfFruits++;
            }
            box.numOfFruits = 0;
        }
    }
}
