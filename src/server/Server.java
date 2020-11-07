package server;

import client.Client;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {

    static int port = 4444;
    static ServerSocket serverSocket = null;

    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(port);
            acceptClients();
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port + ".");
            System.exit(1);
        }

    }

    public static void acceptClients() {
        ArrayList clients = new ArrayList<ClientThread>();
        while (true){
            try {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);
                System.out.println("Client Joined.");
            } catch (IOException e){
                System.out.println("Accept failed on: " + port);
            }
        }
    }


}
