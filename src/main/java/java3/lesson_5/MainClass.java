package java3.lesson_5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        AtomicInteger count = new AtomicInteger(CARS_COUNT);
        Semaphore tl = new Semaphore(CARS_COUNT/2);
        CyclicBarrier stack = new CyclicBarrier(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(tl), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), stack, count);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
}




