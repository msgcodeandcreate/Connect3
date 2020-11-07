import java.awt.image.BufferedImage;
import java.net.Socket;

public class serverThread implements Runnable{

    private Socket socket;
    private String name;
    private BufferedReader serverIn;
    private BufferedImage clientIn;

    public serverThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //TODO make thread relay messages
    }
}
