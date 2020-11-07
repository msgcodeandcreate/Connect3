import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args){
        Socket clientSocket = null;
        int port = 4444;
        try {
            clientSocket = new Socket("localhost", port);
        } catch (IOException e){
            System.err.println("Connection Failed.");
            e.printStackTrace();
        }
    }
}
