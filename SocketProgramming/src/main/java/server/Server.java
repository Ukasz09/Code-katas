package server;

import java.io.*;
import java.net.*;

public class Server {
    public static final int DEFAULT_PORT = 6666;
    private static final String EXIT_MSG = "DISCONNECT";

    private ServerSocket serverSocket;

    //----------------------------------------------------------------------------------------------------------------//
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        connectNewClients();
    }

    private void connectNewClients() throws IOException {
        while (true)
            new ClientHandler(serverSocket.accept(), EXIT_MSG).start();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    //----------------------------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) throws IOException {
        new Server().start(DEFAULT_PORT);
    }
}
