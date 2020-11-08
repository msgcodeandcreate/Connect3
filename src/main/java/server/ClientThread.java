package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Server implements Runnable {

    private Socket socket;
    private PrintWriter clientOut;
    private Server server;

    public ClientThread(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    private PrintWriter getWriter() {
        return clientOut;
    }

    /**
     * Sets up a new Socket connection and broadcasts incoming traffic to all connected clients
     */
    @Override
    public void run() {
        try {
            // setup
            this.clientOut = new PrintWriter(socket.getOutputStream(), false);
            Scanner in = new Scanner(socket.getInputStream());

            // start communicating
            while (!socket.isClosed()) {
                if (in.hasNextLine()) {
                    String input = in.nextLine();
                    System.out.println(input);

                    input = checkInput(input);

                    for (ClientThread thatClient : server.getClients()) {
                        PrintWriter thatClientOut = thatClient.getWriter();
                        if (thatClientOut != null) {
                            thatClientOut.write(input + "\r\n");
                            thatClientOut.flush();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets information from server traffic and can filter said traffic
     *
     * @param input from server
     * @return modified original input
     */
    public String checkInput(String input) {

        return input;
    }

}
