package java3.lesson_4;

public class Mfu extends Thread {
    private static boolean scan = false;
    private static boolean print = false;
    private String command;
    GetCommand com;

    public Mfu(GetCommand com) {
        this.com = com;
    }

    public void run() {
        try {
            this.sleep(200);
            command = this.com.getCommand();
            if ("scan".equals(command) && !scan) {
                scan = true;
                scan();
                this.sleep(6000);
                scan=false;
            } else if ("print".equals(command) && !print) {
                print = true;
                print();
                this.sleep(6000);
                print=false;
            } else {
                System.out.println("Wrong command");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scan() {
        System.out.println("I'am scan now: " + this.getName());
    }

    public void print() {
        System.out.println("I'am print now: " + this.getName());
    }
}
