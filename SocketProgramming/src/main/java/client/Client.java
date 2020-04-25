package client;

import server.Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    //----------------------------------------------------------------------------------------------------------------//
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    //----------------------------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("127.0.0.1", Server.DEFAULT_PORT);
            Scanner sc = new Scanner(System.in);
            while (true) {
                String response = client.sendMessage(sc.nextLine());
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}