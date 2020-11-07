import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args){
        Socket clientSocket = null;
        System.out.println("Please enter username: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        scan.close();
        int port = 4444;
        try {
            clientSocket = new Socket("localhost", port);
            Thread.sleep(1000);
            Thread server = new Thread(new serverThread(clientSocket, name));
            server.start();
        } catch (IOException e){
            System.err.println("Connection Failed.");
            e.printStackTrace();
        } catch (InterruptedException e){
            System.err.println("Connection Failed.");
            e.printStackTrace();
        }
    }
}
