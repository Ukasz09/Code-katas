package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String exitMsg;

    //----------------------------------------------------------------------------------------------------------------//
    public ClientHandler(Socket socket, String exitMsg) throws IOException {
        this.clientSocket = socket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.exitMsg = exitMsg;
    }

    //----------------------------------------------------------------------------------------------------------------//
    @Override
    public void run() {
        try {
            readMessages();
            close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        String inputLine = "";
        while (!inputLine.equals(exitMsg)) {
            inputLine = in.readLine();
            out.println("SERVER RESPONSE: " + inputLine + "- I like it <3");
        }
        System.out.println("Disconnecting client");
    }

    private void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}