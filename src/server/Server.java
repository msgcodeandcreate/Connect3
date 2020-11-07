package server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {

    private static final int portNumber = 4444;

    private int serverPort;
    private ArrayList<ClientThread> clients; // or "protected static List<ClientThread> clients;"

    public static void main(String[] args){
        Server server = new Server(portNumber);
        server.startServer();
    }

    public Server(int portNumber){
        this.serverPort = portNumber;
    }

    public ArrayList<ClientThread> getClients(){
        return clients;
    }

    private void startServer(){
        clients = new ArrayList<ClientThread>();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            acceptClients(serverSocket);
        } catch (IOException e){
            System.err.println("Could not listen on port: "+serverPort);
            System.exit(1);
        }
    }

    private void acceptClients(ServerSocket serverSocket){

        System.out.println("server starts port = " + serverSocket.getLocalSocketAddress());
        while(true){
            try{
                Socket socket = serverSocket.accept();
                System.out.println("accepts : " + socket.getRemoteSocketAddress());
                ClientThread client = new ClientThread(this, socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);
            } catch (IOException ex){
                System.out.println("Accept failed on : "+serverPort);
            }
        }
    }

}
