package client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("", Integer.parseInt(args[0]));
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //listen thread.

        new Thread(() -> {
            boolean alive = true;
            while(alive) {
                boolean end = false;
                try {
                    DataInputStream in = new DataInputStream(s.getInputStream());


                } catch (IOException e) {
                    e.printStackTrace();
                    alive = false;
                }
            }
        }).start();
    }
}
