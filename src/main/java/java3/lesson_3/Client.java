package java3.lesson_3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {
    static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 11111);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(new Client());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
