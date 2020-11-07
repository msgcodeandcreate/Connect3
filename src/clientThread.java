import java.net.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class clientThread implements Runnable {
    ArrayList<clientThread> clients = new ArrayList<clientThread>();

    private String name;
    private String password;
    private Socket socket;
    private PrintWriter out;

    public clientThread(String name, String password, Socket socket){
        this.name = name;
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
