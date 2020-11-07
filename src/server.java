import java.net.*;
import java.io.*;

public class server {
<<<<<<< HEAD
    //private ServerSocket serverSocket;
    public static void main(String[] args){
        ServerSocket serverSocket;
        int portNumber =4444;
        //initialisiere den Socket
        try {
            serverSocket = new ServerSocket(portNumber);

        } catch (IOException e){
            System.err.println("Port: "+portNumber+" konnte nicht benutzt werden");
            System.exit(1);
        }

        //akzeptiere alle Clients
        while(true){
            try{
                
				Socket socket = serverSocket.accept();
            }catch(IOException e){
                System.out.println("Accept failed on: "+portNumber)
            }
        }

    }

=======
>>>>>>> 6b0ea7dbc7325807d3acfb7a3e6e7134e495d6dc

}
