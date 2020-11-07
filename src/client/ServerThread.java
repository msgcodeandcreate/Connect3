package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{

    private Socket socket;
    private String name;
    private BufferedReader serverIn;
    private BufferedReader clientIn;
    private PrintWriter out;

    public ServerThread(Socket socket, String name){
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clientIn = new BufferedReader(new InputStreamReader(System.in));

            while (!socket.isClosed()){
                if (serverIn.ready()){
                    String input = serverIn.readLine();
                    if (input != null){
                        System.out.println(input);
                    }
                }
                if (clientIn.ready()){
                    out.println(name + ": " + clientIn.readLine());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

