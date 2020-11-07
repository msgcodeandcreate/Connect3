package server;

import java.net.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientThread implements Runnable {
    ArrayList<ClientThread> clients = new ArrayList<ClientThread>();

    private String username;
    private String password;
    private Socket socket;
    private PrintWriter out;

    public ClientThread(String username, String password, Socket socket){
        this.username = username;
        this.password = password;
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            out = new PrintWriter(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
