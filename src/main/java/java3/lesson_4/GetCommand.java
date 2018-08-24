package java3.lesson_4;

import java.util.Scanner;

public class GetCommand {
    synchronized public String getCommand() {
        System.out.println("Tape a command:");
        Scanner con = new Scanner(System.in);
        return con.nextLine();
    }
}
