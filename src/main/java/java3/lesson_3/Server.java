package java3.lesson_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;

    {
        try {
            server = new ServerSocket(11111); {
                Socket client = server.accept();
                System.out.println("Server accepted");
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                Client clientObject = null;
                while(true) {
                    try {
                        clientObject = (Client)in.readObject();
                    } catch (ClassNotFoundException e) {
                        System.out.println("There is no serialased objects!");
                        e.printStackTrace();
                    }
                    finally {
                        in.close();
                        break;
                    }
                }
                System.out.println(clientObject.getClass());
                System.out.println("We are get serialised object: " + clientObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
