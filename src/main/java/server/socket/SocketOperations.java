package server.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketOperations {
    ServerSocket mySocket;
    public void initServerSocket(int port) throws IOException {
        mySocket = new ServerSocket(port);
    }

    public void connectClient() {

    }

    public void listen() {

    }
}
