package server;

import message.Message;
import protobuf.MessageProtoBuf;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {
    public static void main(String[] args) throws IOException {
        BlockingQueue<MessageProtoBuf.Message> messageQueue = new LinkedBlockingQueue<MessageProtoBuf.Message>();
        ServerSocket listener = new ServerSocket(Integer.parseInt(args[0]));
        try {
            while (true) {
                Socket socket = listener.accept();
                //ReadThread
                new Thread(() -> {
                    boolean alive = true;
                    while (alive) {
                        try {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(new Date().toString());
                            System.out.println("Client: " + socket.toString() + " has connected");
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            alive = false;
                            System.out.println("Client: " + socket.toString() + " has left the session");
                        }
                    }
                }).start();
                //interpret messages
                /*new Thread(() -> {
                    boolean alive = true;
                    while (alive) {
                        try {
                            MessageProtoBuf.Message m = messageQueue.take();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();*/

            }
        } finally {
            listener.close();
        }
    }
}