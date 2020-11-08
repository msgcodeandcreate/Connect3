package client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private String userName;
    private String serverHost;
    private int serverPort;

    public Client(String userName) {
        this.userName = userName;
        this.serverHost = "localhost";
        this.serverPort = 4444;
    }

    /**
     * Starts up client that tries to connect a socket to a Server:Port and initiate a new ServerThread.
     * Then waits for new Line to be typed to add that message to its ServerThread.
     */
    public void startClient() {
        try {
            Scanner scan = new Scanner(System.in);
            Socket socket = new Socket(serverHost, serverPort);
            Thread.sleep(1000); // waiting for network communicating.

            ServerThread serverThread = new ServerThread(socket, userName);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();
            while (serverAccessThread.isAlive()) {
                if (scan.hasNextLine()) {
                    serverThread.addNextMessage(scan.nextLine());   //Add message to "checkout"
                }
            }
        } catch (IOException ex) {
            System.err.println("Connection error.");
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            System.out.println("Interrupted.");
        }
    }

}
