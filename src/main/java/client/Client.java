package client;
import java.io.IOException;
import java.net.Socket;
import java.rmi.server.UID;
import java.util.Scanner;

public class Client {

    private String userName;
    private String serverHost;
    private int serverPort;
    private Scanner userInputScanner;



    public Client(String userName){
        this.userName = userName;
        this.serverHost = "localhost";
        this.serverPort = 4444;
    }

    public void startClient(){
        try{
            Scanner scan = new Scanner(System.in);
            Socket socket = new Socket(serverHost, serverPort);
            Thread.sleep(1000); // waiting for network communicating.

            ServerThread serverThread = new ServerThread(socket, userName);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();
            while(serverAccessThread.isAlive()){
                if(scan.hasNextLine()){
                    serverThread.addNextMessage(scan.nextLine());   //Add message to "checkout"
                }
            }
        }catch(IOException ex){
            System.err.println("Connection error.");
            ex.printStackTrace();
        }catch(InterruptedException ex){
            System.out.println("Interrupted.");
        }
    }

}
