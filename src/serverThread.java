import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class serverThread implements Runnable{

    private Socket socket;
    private String name;
    private BufferedReader serverIn;
    private BufferedReader clientIn;
    private PrintWriter out;

    public serverThread(Socket socket, String name){
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket)
        } catch (IOException e){
            e.printStackTrace();;
        }
    }
}
