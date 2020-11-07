import java.net.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.ArrayList;

public class clientThread implements Runnable {
    ArrayList<clientThread> clients = new ArrayList<clientThread>();

    private String username;
    private String password;
    private Socket socket;
    private PrintWriter out;

    public clientThread(String username, String password, Socket socket){
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
