package server;

import client.Client;

import java.net.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientThread extends Server implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (!socket.isClosed()){
                String input = in.readLine();
                if (input != null){
                    for (ClientThread client : clients){
                        client.getWriter().write(input);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrintWriter getWriter(){
        return out;
    }

}
