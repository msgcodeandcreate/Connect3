import java.net.*;
import java.io.*;

public class server {
    //private ServerSocket serverSocket;
    public static void main(String[] args){
        ServerSocket serverSocket;
        int portNumber =4444;
        //initialisiere den Socket
        try {
            serverSocket = new ServerSocket(portNumber);


            //akzeptiere alle Clients
        while(true){
            try{
                
				Socket socket = serverSocket.accept();
            }catch(IOException e){
                System.out.println("Accept failed on: "+portNumber);
            }
        }

        } catch (IOException e){
            System.err.println("Port: "+portNumber+" konnte nicht benutzt werden");
            System.exit(1);
        }

        

    }


}
