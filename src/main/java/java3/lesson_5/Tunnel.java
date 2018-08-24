package java3.lesson_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore tl;
    public Tunnel(Semaphore tl) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.tl = tl;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                tl.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                System.out.println(c.getName() + " закончил этап: " + description);
                tl.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}