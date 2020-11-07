
import java.net.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClientThread extends Server implements Runnable {

    private Socket socket;
    private PrintWriter clientOut;
    private Server server;

    public ClientThread(Server server, Socket socket){
        this.server = server;
        this.socket = socket;
    }

    private PrintWriter getWriter(){
        return clientOut;
    }

    @Override
    public void run() {
        try{
            // setup
            this.clientOut = new PrintWriter(socket.getOutputStream(), false);
            Scanner in = new Scanner(socket.getInputStream());

            // start communicating
            while(!socket.isClosed()){
                if(in.hasNextLine()){
                    String input = in.nextLine();
                    System.out.println(input);

                    input = checkInput(input);

                    for(ClientThread thatClient : server.getClients()){
                        PrintWriter thatClientOut = thatClient.getWriter();
                        if(thatClientOut != null){
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


    private String[][] accounts;



    public String checkInput(String input){
        //Get username
        int position = input.indexOf(">");
        String newName = input.substring(0, position-1);

        //testen ob bestimmter Befehl eingegeben wurde
        switch(input){
            case "/whoison":
                String users = "";
                for (String name : usersOnline){
                    if (name != null)
                        users += name + "|";
                }
                break;
            input = "/whoison: " + "|" + users;
            case "/help":
                System.out.println("
                \help: show this;
                \whoison: shows who is currently online;
                \showProfile NAME : shows the profile of NAME;
                ");
                break;
            case "\showProfile NAME":
                
        }



        //List all users currently considered online

        /*
        if (input.contains("/whoison")){
            String users = "";
            for (String name : usersOnline){
                if (name != null)
                    users += name + "|";
            }
            input = "/whoison: " + "|" + users;
        }
        */

        //TODO (curse word filter)

        //Checks if username belongs to new user
        for (String name : usersOnline){
            if (newName == name){
                return input;
            }
        }
        for (int i = 0; i < usersOnline.length; i++){
            if (usersOnline[i] == "" || usersOnline[i] == null){
                usersOnline[i] = newName;
                return input;
            }
        }

        return input;
    }

}
